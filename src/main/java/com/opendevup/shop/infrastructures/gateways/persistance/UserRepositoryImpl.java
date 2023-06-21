package com.opendevup.shop.infrastructures.gateways.persistance;

import com.opendevup.shop.application.gateways.repositories.UserRepository;
import com.opendevup.shop.domain.User;
import com.opendevup.shop.infrastructures.gateways.persistance.repositories.UserPostgreSQLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserPostgreSQLRepository userPostgreSQLRepository;

    @Override
    public Mono<User> save(User user) {
        return userPostgreSQLRepository.save(UserMapper.toEntity(user))
                .map(UserMapper::toDomain);
    }

    @Override
    public Flux<User> findAll() {
        return userPostgreSQLRepository.findAll()
                .map(UserMapper::toDomain);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return userPostgreSQLRepository.deleteById(id);
    }

    @Override
    public Mono<User> findById(Long id) {
        return userPostgreSQLRepository.findById(id)
                .map(UserMapper::toDomain);
    }

    @Override
    public Mono<User> findByUsername(String username) {
        return userPostgreSQLRepository.findByUsername(username)
                .map(UserMapper::toDomain);
    }
}
