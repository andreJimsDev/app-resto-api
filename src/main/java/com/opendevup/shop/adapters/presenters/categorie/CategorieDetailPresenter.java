package com.opendevup.shop.adapters.presenters.categorie;

import com.opendevup.shop.application.presenters.categorie.CategorieDetailOutputBoundary;
import com.opendevup.shop.application.presenters.categorie.CategorieDetailViewModel;
import com.opendevup.shop.domain.Categorie;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CategorieDetailPresenter implements CategorieDetailOutputBoundary {

    private Mono<CategorieDetailViewModel> viewModel;

    @Override
    public Mono<CategorieDetailViewModel> getViewModel() {
        return viewModel;
    }

    @Override
    public void present(Mono<Categorie> response) {
        viewModel = response.map(this::mapToCategorieViewModel);
    }

    private CategorieDetailViewModel mapToCategorieViewModel(Categorie categorie) {
        return CategorieDetailViewModel.builder()
                .id(categorie.getId())
                .nom(categorie.getNom())
                .order(categorie.getOrdre())
                .tvaEmporte(categorie.getTvaEmporte())
                .tvaSurPlace(categorie.getTvaSurPlace())
                .visibleCarte1(categorie.isVisibleCarte1())
                .visibleCarte2(categorie.isVisibleCarte2())
                .parent(categorie.getParent())
                .build();
    }
}
