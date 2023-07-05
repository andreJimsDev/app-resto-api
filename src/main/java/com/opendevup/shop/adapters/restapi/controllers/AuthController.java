package com.opendevup.shop.adapters.restapi.controllers;

import com.opendevup.shop.adapters.persistence.user.JpaRoleRepository;
import com.opendevup.shop.adapters.persistence.user.JpaUserRepository;
import com.opendevup.shop.adapters.persistence.user.RoleEntity;
import com.opendevup.shop.adapters.persistence.user.UserEntity;
import com.opendevup.shop.adapters.restapi.payload.request.LoginRequest;
import com.opendevup.shop.adapters.restapi.payload.request.SignupRequest;
import com.opendevup.shop.adapters.restapi.payload.response.JwtResponse;
import com.opendevup.shop.adapters.restapi.payload.response.MessageResponse;
import com.opendevup.shop.adapters.restapi.security.jwt.JwtUtils;
import com.opendevup.shop.adapters.restapi.security.services.UserDetailsImpl;
import com.opendevup.shop.domain.ERole;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    @Autowired
    JpaUserRepository userRepository;

    @Autowired
    JpaRoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/signIn")
    public ResponseEntity<?> signInUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity
                .ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), roles));
    }

    @GetMapping("/init")
    public ResponseEntity<?> initUser(){
        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setUsername("admin");
        signUpRequest.setPassword("admin");

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        UserEntity user = UserEntity.builder()
                .username(signUpRequest.getUsername())
                .password(encoder.encode(signUpRequest.getPassword()))
                .build();

        Set<RoleEntity> roles = new HashSet<>();

        RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role user is not found."));
        roles.add(userRole);

        RoleEntity adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role admin is not found."));
        roles.add(adminRole);

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
