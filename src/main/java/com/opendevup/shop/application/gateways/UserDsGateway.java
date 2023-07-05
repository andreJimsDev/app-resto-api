package com.opendevup.shop.application.gateways;

import com.opendevup.shop.domain.User;

public interface UserDsGateway {
    User findByUsername(String username);
}
