package com.opendevup.shop.application.gateways.repositories;

import com.opendevup.shop.domain.User;
import reactor.core.publisher.Mono;

public interface UserRepository extends BaseRepository<User>{
    Mono<User> findByUsername(String username);
}
