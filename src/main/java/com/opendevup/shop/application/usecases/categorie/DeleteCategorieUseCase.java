package com.opendevup.shop.application.usecases.categorie;

import com.opendevup.shop.application.gateways.CategorieDsGateway;
import com.opendevup.shop.application.presenters.DeleteOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteCategorieUseCase implements UseCase<Long> {

    private final CategorieDsGateway categorieDsGateway;
    private final DeleteOutputBoundary presenter;

    @Override
    public void execute(Long id) {
        Mono<Void> response = categorieDsGateway.delete(id);
        presenter.present(response);
    }
}
