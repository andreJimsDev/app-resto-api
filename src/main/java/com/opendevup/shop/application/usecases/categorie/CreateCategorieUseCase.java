package com.opendevup.shop.application.usecases.categorie;

import com.opendevup.shop.application.gateways.CategorieDsGateway;
import com.opendevup.shop.application.presenters.categorie.CategorieOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateCategorieUseCase implements UseCase<Mono<CreateCategorieRequest>> {

    private final CategorieDsGateway categorieDsGateway;
    private final CategorieOutputBoundary presenter;

    @Override
    public void execute(Mono<CreateCategorieRequest> request) {
        Mono<Categorie> response = request.flatMap(
                createCategorieRequest -> categorieDsGateway.save(
                        Categorie.builder()
                                .nom(createCategorieRequest.getNom())
                                .build()
                )
        );
        presenter.present(response);
    }
}
