package com.opendevup.shop.adapters.restapi.controllers;

import com.opendevup.shop.application.presenters.auth.AuthOutputBoundary;
import com.opendevup.shop.application.presenters.auth.AuthViewModel;
import com.opendevup.shop.application.usecases.auth.SignInUserRequest;
import com.opendevup.shop.application.usecases.auth.SignInUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final SignInUserUseCase signInUserUseCase;
    private final AuthOutputBoundary presenter;

    @PostMapping("/signIn")
    public Mono<AuthViewModel> signIn(
            @Valid @RequestBody Mono<SignInUserRequest> authRequest) {
        signInUserUseCase.execute(authRequest);
        return presenter.getViewModel();
    }
}
