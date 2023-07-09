package com.opendevup.shop;

import com.opendevup.shop.application.usecases.user.AuthRequest;
import com.opendevup.shop.application.usecases.user.SignUpUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    @Autowired
    private SignUpUserUseCase signUpUserUseCase;

    //@PostConstruct
    public void init(){
        initAuth();
    }

    private void initAuth() {
        signUpUserUseCase.execute(new AuthRequest("admin", "admin".toCharArray()));
    }

}
