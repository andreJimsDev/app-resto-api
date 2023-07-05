package com.opendevup.shop.application.gateways;

public interface SecurityGateway {
    String hashPassword(String password);
    String authenticate(String username, String password);
}
