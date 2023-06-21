package com.opendevup.shop.application.usecases.auth;

import com.opendevup.shop.application.command.SignInUserCommand;
import com.opendevup.shop.application.gateways.repositories.UserRepository;
import com.opendevup.shop.application.gateways.services.SecurityService;
import com.opendevup.shop.application.usecases.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SignInUserUseCase implements UseCase<Mono<SignInUserCommand>, Mono<String>> {

    private final SecurityService securityService;
    private final UserRepository userRepository;

    @Override
    public Mono<String> execute(Mono<SignInUserCommand> signInUserCommand) {
        return signInUserCommand.flatMap(command ->
                userRepository.findByUsername(command.username())
                        .switchIfEmpty(Mono.error(new RuntimeException("The user is not found")))
                        .flatMap(user -> {
                            String passwordHashed = securityService.hashPassword(command.password());
                            boolean isMatchPassword = passwordHashed.equals(user.password());
                            if (!isMatchPassword)
                                Mono.error(new RuntimeException("There's no user from matching password"));
                            return securityService.authenticate(command.username(), command.password());
                        })
        );
    }
}
