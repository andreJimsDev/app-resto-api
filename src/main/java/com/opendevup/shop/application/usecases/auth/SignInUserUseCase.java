package com.opendevup.shop.application.usecases.auth;

import com.opendevup.shop.application.gateways.SecurityGateway;
import com.opendevup.shop.application.gateways.UserDsGateway;
import com.opendevup.shop.application.presenters.auth.AuthOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SignInUserUseCase implements UseCase<Mono<SignInUserRequest>> {

    private final SecurityGateway securityGateway;
    private final UserDsGateway userDsGateway;
    private final AuthOutputBoundary presenter;

    @Override
    public void execute(Mono<SignInUserRequest> signInUserRequestMono) {
        Mono<String> response = signInUserRequestMono.flatMap(signInUserRequest ->
                userDsGateway.findByUsername(signInUserRequest.getUsername())
                        .switchIfEmpty(Mono.error(new RuntimeException("The user is not found")))
                        .flatMap(user -> {
                            String passwordHashed = securityGateway.hashPassword(signInUserRequest.getPassword());
                            boolean isMatchPassword = passwordHashed.equals(user.password());
                            if (!isMatchPassword)
                                Mono.error(new RuntimeException("There's no user from matching password"));
                            return securityGateway.authenticate(signInUserRequest.getUsername(), signInUserRequest.getPassword());
                        })
        );
        presenter.present(response);
    }
}
