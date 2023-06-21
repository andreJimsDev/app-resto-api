package com.opendevup.shop.infrastructures.gateways.persistance.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "users")
public class UserEntity {
    @Id
    private Long id;
    private String username;
    private String password;
    private String role;
}
