package com.opendevup.shop.adapters.persistence.user;

import com.opendevup.shop.application.gateways.UserDsGateway;
import com.opendevup.shop.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaUserGateway implements UserDsGateway {

    private final JpaUserRepository jpaRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> findByUsername(String username) {
        return jpaRepository.findByUsername(username)
                .map(userEntityMapper::toDomain);
    }

    @Override
    public User save(User user) {
        return userEntityMapper.toDomain(
                jpaRepository.save(userEntityMapper.toEntity(user))
        );
    }
}
