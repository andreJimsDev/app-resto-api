package com.opendevup.shop.application.presenters.auth;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuthViewModel {
    private String accessToken;
    private String role;
}
