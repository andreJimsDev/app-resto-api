package com.opendevup.shop.adapters.restapi.security;

import com.opendevup.shop.adapters.restapi.security.jwt.JwtTokenProvider;
import com.opendevup.shop.application.gateways.SecurityGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SecurityGatewayImpl implements SecurityGateway {

    private final JwtTokenProvider tokenProvider;
    private final ReactiveAuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;

    @Override
    public String hashPassword(String password) {
        return encoder.encode(password);
    }

    @Override
    public Mono<String> authenticate(String username, String password) {
        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        username, password)
                )
                .map(this.tokenProvider::createToken);
    }

}
