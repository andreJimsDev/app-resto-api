package com.opendevup.shop.application.gateways;

public interface PasswordGateway {
    boolean matches(CharSequence passwordInput, String passwordStored);
    String encode(CharSequence passwordInput);
}
