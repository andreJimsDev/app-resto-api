package com.opendevup.shop.adapters.persistence.role;

import com.opendevup.shop.domain.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface RoleEntityMapper {
    Role toDomain(RoleEntity roleEntity);

    RoleEntity toEntity(Role role);
}
