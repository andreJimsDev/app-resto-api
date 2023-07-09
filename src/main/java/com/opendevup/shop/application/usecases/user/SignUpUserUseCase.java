package com.opendevup.shop.application.usecases.user;

import com.opendevup.shop.application.gateways.PasswordGateway;
import com.opendevup.shop.application.gateways.RoleDsCateway;
import com.opendevup.shop.application.gateways.UserDsGateway;
import com.opendevup.shop.application.presenters.auth.AuthOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.ERole;
import com.opendevup.shop.domain.Role;
import com.opendevup.shop.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SignUpUserUseCase implements UseCase<AuthRequest> {

    private final UserDsGateway userDsGateway;
    private final RoleDsCateway roleDsCateway;
    private final AuthOutputBoundary presenter;
    private final PasswordGateway passwordGateway;

    @Override
    public void execute(AuthRequest request) {
        Set<Role> roles = new HashSet<>();
        Role adminRole = roleDsCateway.findByName(ERole.ROLE_ADMIN)
                .orElse(roleDsCateway.save(new Role().withName(ERole.ROLE_ADMIN)));
        roles.add(adminRole);
        Role userRole = roleDsCateway.findByName(ERole.ROLE_USER)
                .orElse(roleDsCateway.save(new Role().withName(ERole.ROLE_USER)));
        roles.add(userRole);
        User user = userDsGateway.save(
                User.builder()
                        .username(request.username())
                        .password(passwordGateway.encode(CharBuffer.wrap(request.password())))
                        .roles(roles)
                        .build()
        );
        presenter.presentSuccess("User registered successfully!", String.valueOf(user.getId()));
    }
}
