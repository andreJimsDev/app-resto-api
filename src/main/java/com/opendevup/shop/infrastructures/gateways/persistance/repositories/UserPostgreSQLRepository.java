package com.opendevup.shop.infrastructures.gateways.persistance.repositories;

import com.opendevup.shop.infrastructures.gateways.persistance.entities.UserEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface UserPostgreSQLRepository extends R2dbcRepository<UserEntity, Long> {
    Mono<UserEntity> findByUsername(String username);
}
