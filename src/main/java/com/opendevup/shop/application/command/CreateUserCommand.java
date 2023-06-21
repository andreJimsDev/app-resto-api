package com.opendevup.shop.application.command;

public record CreateUserCommand(String username, String password, String role) {
}
