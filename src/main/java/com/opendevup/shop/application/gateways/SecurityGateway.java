package com.opendevup.shop.application.gateways;

import reactor.core.publisher.Mono;

public interface SecurityGateway {
    String hashPassword(String password);
    Mono<String> authenticate(String username, String password);
}
