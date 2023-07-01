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
    public void execute(Mono<CreateCategorieRequest> createCategorieRequest) {
        Mono<Categorie> response = createCategorieRequest.flatMap(
                request -> {
                    if (request.getParent() != null) {
                        return categorieDsGateway.findById(
                                request.getParent()
                        ).flatMap(categorie -> categorieDsGateway.save(
                                Categorie.builder()
                                        .nom(request.getNom())
                                        .parent(request.getParent())
                                        .build()
                        )).switchIfEmpty(
                                Mono.error(
                                        new RuntimeException(
                                                "The categorie parent is not found"
                                        )
                                )
                        );
                    }
                    return categorieDsGateway.count().flatMap(
                            count -> categorieDsGateway.save(
                                    Categorie.builder()
                                            .nom(request.getNom())
                                            .ordre(count.intValue() + 1)
                                            .build()
                            )
                    );
                }
        );
        presenter.present(response);
    }
}
