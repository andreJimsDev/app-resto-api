package com.opendevup.shop.adapters.restapi.security;

import com.opendevup.shop.adapters.restapi.config.UserAuthenticationProvider;
import com.opendevup.shop.application.gateways.UserAuthenticationGateway;
import com.opendevup.shop.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAuthenticationProviderGateway implements UserAuthenticationGateway {

    private final UserAuthenticationProvider userAuthenticationProvider;

    @Override
    public String createToken(User user) {
        return userAuthenticationProvider.createToken(user);
    }

    @Override
    public String createRefreshToken(User user) {
        return userAuthenticationProvider.createRefreshToken(user);
    }
}
