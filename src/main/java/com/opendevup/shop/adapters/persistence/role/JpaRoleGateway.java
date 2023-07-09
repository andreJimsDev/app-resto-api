package com.opendevup.shop.adapters.persistence.role;

import com.opendevup.shop.application.gateways.RoleDsCateway;
import com.opendevup.shop.domain.ERole;
import com.opendevup.shop.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaRoleGateway implements RoleDsCateway {

    private final JpaRoleRepository jpaRoleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public Optional<Role> findByName(ERole eRole) {
        return jpaRoleRepository.findByName(eRole)
                .map(roleEntityMapper::toDomain);
    }

    @Override
    public Role save(Role role) {
        return roleEntityMapper.toDomain(
                jpaRoleRepository.save(roleEntityMapper.toEntity(role))
        );
    }
}
