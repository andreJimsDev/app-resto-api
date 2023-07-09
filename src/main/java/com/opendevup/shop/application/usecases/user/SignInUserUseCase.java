package com.opendevup.shop.application.usecases.user;

import com.opendevup.shop.application.gateways.PasswordGateway;
import com.opendevup.shop.application.gateways.UserAuthenticationGateway;
import com.opendevup.shop.application.gateways.UserDsGateway;
import com.opendevup.shop.application.presenters.auth.AuthOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignInUserUseCase implements UseCase<AuthRequest> {

    private final UserAuthenticationGateway userAuthenticationProvider;
    private final UserDsGateway userDsGateway;
    private final AuthOutputBoundary presenter;
    private final PasswordGateway passwordGateway;

    @Override
    public void execute(AuthRequest request) {
        Optional<User> optionalUser = userDsGateway.findByUsername(request.username());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordGateway.matches(
                    CharBuffer.wrap(request.password()), user.getPassword()
            )) {
                presenter.presentSuccess(
                        userAuthenticationProvider.createToken(user),
                        userAuthenticationProvider.createRefreshToken(user)
                );
            } else {
                presenter.presentFail("Invalid password");
            }
        } else {
            presenter.presentFail("Unknown user");
        }
    }
}
