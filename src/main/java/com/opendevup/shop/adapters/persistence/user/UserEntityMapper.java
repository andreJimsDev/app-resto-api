package com.opendevup.shop.adapters.persistence.user;

import com.opendevup.shop.domain.User;

public class UserEntityMapper {
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