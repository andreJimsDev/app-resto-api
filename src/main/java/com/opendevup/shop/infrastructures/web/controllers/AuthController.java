package com.opendevup.shop.infrastructures.web.controllers;

import com.opendevup.shop.application.command.SignInUserCommand;
import com.opendevup.shop.application.usecases.auth.SignInUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final SignInUserUseCase signInUserUseCase;

    @PostMapping("/login")
    public Mono<ResponseEntity> signIn(
            @Valid @RequestBody Mono<SignInUserCommand> authRequest) {

        return signInUserUseCase.execute(authRequest)
                .map(jwt -> {
                    HttpHeaders httpHeaders = new HttpHeaders();
                    httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);
                    var tokenBody = Map.of("access_token", jwt);
                    return new ResponseEntity<>(tokenBody, httpHeaders, HttpStatus.OK);
                });
    }
}
