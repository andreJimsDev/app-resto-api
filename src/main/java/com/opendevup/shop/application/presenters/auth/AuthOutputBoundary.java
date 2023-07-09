package com.opendevup.shop.application.presenters.auth;

public interface AuthOutputBoundary {
    void presentSuccess(String token, String refreshToken);
    void presentFail(String error);

    AuthViewModel getViewModel();
}
