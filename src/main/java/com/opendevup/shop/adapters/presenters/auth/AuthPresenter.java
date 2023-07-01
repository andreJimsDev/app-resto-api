package com.opendevup.shop.adapters.presenters.auth;

import com.opendevup.shop.application.presenters.auth.AuthOutputBoundary;
import com.opendevup.shop.application.presenters.auth.AuthViewModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthPresenter implements AuthOutputBoundary {

    private Mono<AuthViewModel> authViewModel;

    @Override
    public Mono<AuthViewModel> getViewModel() {
        return authViewModel;
    }

    @Override
    public void present(Mono<String> response) {
        authViewModel = response.map(this::mapToAuthViewModel);
    }

    private AuthViewModel mapToAuthViewModel(String accessToken) {
        return AuthViewModel
                .builder()
                .accessToken(accessToken)
                .build();
    }
}
