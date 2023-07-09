package com.opendevup.shop.application.gateways;

import com.opendevup.shop.domain.User;

import java.util.Optional;

public interface UserDsGateway {
    Optional<User> findByUsername(String username);
    User save(User user);
}
