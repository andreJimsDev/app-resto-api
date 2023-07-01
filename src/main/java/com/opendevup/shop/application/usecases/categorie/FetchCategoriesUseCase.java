package com.opendevup.shop.application.usecases.categorie;

import com.opendevup.shop.application.gateways.CategorieDsGateway;
import com.opendevup.shop.application.presenters.categorie.CategoriesOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FetchCategoriesUseCase implements UseCase<String> {

    private final CategorieDsGateway categorieDsGateway;
    private final CategoriesOutputBoundary presenter;

    @Override
    public void execute(String request) {
        Flux<Categorie> response = categorieDsGateway.findAll();
        presenter.present(response);
    }
}
