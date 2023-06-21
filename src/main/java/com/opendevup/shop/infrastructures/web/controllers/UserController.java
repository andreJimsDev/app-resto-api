package com.opendevup.shop.infrastructures.web.controllers;

import com.opendevup.shop.application.command.CreateUserCommand;
import com.opendevup.shop.application.responses.CreateUserResponse;
import com.opendevup.shop.application.usecases.user.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public Mono<ResponseEntity<Mono<CreateUserResponse>>> createUser(@RequestBody Mono<CreateUserCommand> createUserCommandMono) {
        return createUserCommandMono.map(
                createUserUseCase::execute
        ).map(ResponseEntity::ok);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public Flux<String> adminConnected() {
        return Flux.just("User admin is connected");
    }

    @PreAuthorize("hasRole('SERVEUR')")
    @GetMapping("/serveur")
    public Flux<String> serverConnected() {
        return Flux.just("User serveur is connected");
    }

    @GetMapping("/me")
    public Mono<Map<String, Object>> current(@AuthenticationPrincipal Mono<UserDetails> principal) {
        return principal.map(user -> Map.of(
                        "name", user.getUsername(),
                        "roles", AuthorityUtils.authorityListToSet(user.getAuthorities())
                )
        );
    }

}
