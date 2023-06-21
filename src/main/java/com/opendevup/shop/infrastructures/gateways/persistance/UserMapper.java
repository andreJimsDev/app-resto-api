package com.opendevup.shop.infrastructures.gateways.persistance;

import com.opendevup.shop.domain.User;
import com.opendevup.shop.infrastructures.gateways.persistance.entities.UserEntity;

public class UserMapper {
    public static User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getRole()
        );
    }

    public static UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.id());
        userEntity.setRole(user.role());
        userEntity.setPassword(user.password());
        userEntity.setUsername(user.username());
        return userEntity;
    }
}
