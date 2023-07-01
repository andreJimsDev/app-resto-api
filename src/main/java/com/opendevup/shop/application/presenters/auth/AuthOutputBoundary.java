package com.opendevup.shop.application.presenters.auth;

import reactor.core.publisher.Mono;

public interface AuthOutputBoundary {
    Mono<AuthViewModel> getViewModel();
    void present(Mono<String> response);
}
