package com.opendevup.shop.application.gateways;

import com.opendevup.shop.domain.ERole;
import com.opendevup.shop.domain.Role;

import java.util.Optional;

public interface RoleDsCateway {
    Optional<Role> findByName(ERole eRole);
    Role save(Role role);
}
