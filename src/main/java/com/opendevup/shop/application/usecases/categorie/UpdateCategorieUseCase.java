package com.opendevup.shop.application.usecases.categorie;

import com.opendevup.shop.application.gateways.CategorieDsGateway;
import com.opendevup.shop.application.presenters.categorie.CategorieOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCategorieUseCase implements UseCase<UpdateCategorieRequest> {

    private final CategorieDsGateway categorieDsGateway;
    private final CategorieOutputBoundary presenter;

    @Override
    public void execute(UpdateCategorieRequest request) {
        presenter.present(
                categorieDsGateway.save(
                        Categorie.builder()
                                .id(request.getId())
                                .nom(request.getNom())
                                .ordre(request.getOrder())
                                .tvaEmporte(request.getTvaEmporte())
                                .tvaSurPlace(request.getTvaSurPlace())
                                .visibleCarte1(request.isVisibleCarte1())
                                .visibleCarte2(request.isVisibleCarte2())
                                .parent(request.getParent())
                                .build()
                )
        );
    }
}
