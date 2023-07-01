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
public class UpdateCategorieUseCase implements UseCase<Mono<UpdateCategorieRequest>> {

    private final CategorieDsGateway categorieDsGateway;
    private final CategorieOutputBoundary presenter;

    @Override
    public void execute(Mono<UpdateCategorieRequest> request) {
        Mono<Categorie> response = request.flatMap(
                updateCategorieRequest -> categorieDsGateway.save(
                        Categorie.builder()
                                .id(updateCategorieRequest.getId())
                                .nom(updateCategorieRequest.getNom())
                                .ordre(updateCategorieRequest.getOrder())
                                .tvaEmporte(updateCategorieRequest.getTvaEmporte())
                                .tvaSurPlace(updateCategorieRequest.getTvaSurPlace())
                                .visibleCarte1(updateCategorieRequest.isVisibleCarte1())
                                .visibleCarte2(updateCategorieRequest.isVisibleCarte2())
                                .parent(updateCategorieRequest.getParent())
                                .build()
                )
        );
        presenter.present(response);
    }
}
