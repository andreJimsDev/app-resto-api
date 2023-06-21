package com.opendevup.shop.application.usecases.user;

import com.opendevup.shop.application.command.CreateUserCommand;
import com.opendevup.shop.application.gateways.repositories.UserRepository;
import com.opendevup.shop.application.gateways.services.SecurityService;
import com.opendevup.shop.application.responses.CreateUserResponse;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CreateUserUseCase implements UseCase<CreateUserCommand, Mono<CreateUserResponse>> {

    private final UserRepository userRepository;
    private final SecurityService securityService;

    @Override
    public Mono<CreateUserResponse> execute(CreateUserCommand createUserCommand) {
        return userRepository.findByUsername(createUserCommand.username())
                .defaultIfEmpty(new User(null, null, null, null))
                .flatMap(user -> {
                    if (user.id() != null) {
                        return Mono.error(new RuntimeException("User is already exist"));
                    }
                    return userRepository.save(
                            new User(
                                    null,
                                    createUserCommand.username(),
                                    securityService.hashPassword(createUserCommand.password()),
                                    createUserCommand.role()
                            )
                    ).map(userSaved -> new CreateUserResponse(
                            userSaved.id(),
                            userSaved.username()
                    ));
                });
    }
}
