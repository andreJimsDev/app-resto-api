package com.opendevup.shop.application.usecases.categorie;

import com.opendevup.shop.application.gateways.CategorieDsGateway;
import com.opendevup.shop.application.presenters.categorie.CategorieDetailOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FetchCategorieUseCase implements UseCase<Long> {

    private final CategorieDsGateway categorieDsGateway;
    private final CategorieDetailOutputBoundary presenter;

    @Override
    public void execute(Long id) {
        Optional<Categorie> response = categorieDsGateway.findById(id);
        if (response.isPresent())
            presenter.present(response.get());
    }
}
