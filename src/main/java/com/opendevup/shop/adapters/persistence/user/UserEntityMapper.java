package com.opendevup.shop.adapters.persistence.user;

import com.opendevup.shop.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserEntityMapper {
    User toDomain(UserEntity userEntity);

    UserEntity toEntity(User user);
}
