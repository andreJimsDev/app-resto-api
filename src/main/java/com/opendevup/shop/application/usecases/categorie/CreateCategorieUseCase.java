package com.opendevup.shop.application.usecases.categorie;

import com.opendevup.shop.application.gateways.CategorieDsGateway;
import com.opendevup.shop.application.presenters.categorie.CategorieOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCategorieUseCase implements UseCase<CreateCategorieRequest> {

    private final CategorieDsGateway categorieDsGateway;
    private final CategorieOutputBoundary presenter;

    @Override
    public void execute(CreateCategorieRequest request) {
        Categorie response;
        if (request.getParent() != null) {
            categorieDsGateway.findById(
                    request.getParent()
            ).orElseThrow(() ->
                    new RuntimeException(
                            "The categorie parent is not found"
                    )
            );
            response = categorieDsGateway.save(
                    Categorie.builder()
                            .nom(request.getNom())
                            .parent(request.getParent())
                            .build()
            );
        } else {
            Long count = categorieDsGateway.count();
            response = categorieDsGateway.save(
                    Categorie.builder()
                            .nom(request.getNom())
                            .ordre(count.intValue() + 1)
                            .build()
            );
        }
        presenter.present(response);
    }
}
