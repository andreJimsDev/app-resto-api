package com.opendevup.shop.adapters.restapi.security;

import com.opendevup.shop.application.gateways.PasswordGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordEncoderGateway implements PasswordGateway {

    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean matches(CharSequence passwordInput, String passwordStored) {
        return passwordEncoder.matches(passwordInput, passwordStored);
    }

    @Override
    public String encode(CharSequence passwordInput) {
        return passwordEncoder.encode(passwordInput);
    }
}
