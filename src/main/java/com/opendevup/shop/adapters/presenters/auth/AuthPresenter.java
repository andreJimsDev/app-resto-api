package com.opendevup.shop.adapters.presenters.auth;

import com.opendevup.shop.adapters.restapi.exceptions.AppException;
import com.opendevup.shop.application.presenters.auth.AuthOutputBoundary;
import com.opendevup.shop.application.presenters.auth.AuthViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthPresenter implements AuthOutputBoundary {

    private AuthViewModel viewModel;

    @Override
    public void presentSuccess(String token, String refreshToken) {
        viewModel = new AuthViewModel()
                .withAccessToken(token)
                .withRefreshToken(refreshToken);
    }

    @Override
    public void presentFail(String error) {
        throw new AppException(error, HttpStatus.NOT_FOUND);
    }

    @Override
    public AuthViewModel getViewModel() {
        return viewModel;
    }
}
