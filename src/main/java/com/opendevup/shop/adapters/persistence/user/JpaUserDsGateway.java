package com.opendevup.shop.adapters.persistence.user;

import com.opendevup.shop.application.gateways.UserDsGateway;
import com.opendevup.shop.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class JpaUserDsGateway implements UserDsGateway {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public Mono<User> findByUsername(String username) {
        return jpaUserRepository.findByUsername(username)
                .map(UserEntityMapper::toDomain);
    }
}
