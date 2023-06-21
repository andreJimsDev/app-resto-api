package com.opendevup.shop.application.gateways.services;

import reactor.core.publisher.Mono;

public interface SecurityService {
    String hashPassword(String password);
    Mono<String> authenticate(String username, String password);
}
