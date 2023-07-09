package com.opendevup.shop.adapters.restapi.controllers;

import com.opendevup.shop.application.presenters.auth.AuthOutputBoundary;
import com.opendevup.shop.application.presenters.auth.AuthViewModel;
import com.opendevup.shop.application.usecases.user.AuthRequest;
import com.opendevup.shop.application.usecases.user.SignInUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/auth")
public class AuthController {

    private final SignInUserUseCase signInUserUseCase;
    private final AuthOutputBoundary presenter;

    @PostMapping("/signIn")
    public AuthViewModel signInUser(@Valid @RequestBody AuthRequest authRequest) {

        signInUserUseCase.execute(authRequest);

        return presenter.getViewModel();
    }
}
