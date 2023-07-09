package com.opendevup.shop.application.gateways;

import com.opendevup.shop.domain.User;

public interface UserAuthenticationGateway {
    String createToken(User user);
    String createRefreshToken(User user);
}
