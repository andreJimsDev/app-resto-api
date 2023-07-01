package com.opendevup.shop.application.gateways;

import com.opendevup.shop.domain.User;
import reactor.core.publisher.Mono;

public interface UserDsGateway {
    Mono<User> findByUsername(String username);
}
