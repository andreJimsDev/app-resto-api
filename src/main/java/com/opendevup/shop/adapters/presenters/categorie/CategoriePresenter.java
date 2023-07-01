package com.opendevup.shop.adapters.presenters.categorie;

import com.opendevup.shop.application.presenters.categorie.CategorieOutputBoundary;
import com.opendevup.shop.application.presenters.categorie.CategorieViewModel;
import com.opendevup.shop.domain.Categorie;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CategoriePresenter implements CategorieOutputBoundary {

    private Mono<CategorieViewModel> viewModel;

    @Override
    public Mono<CategorieViewModel> getViewModel() {
        return viewModel;
    }

    @Override
    public void present(Mono<Categorie> response) {
        viewModel = response.map(this::mapToCategorieViewModel);
    }

    private CategorieViewModel mapToCategorieViewModel(Categorie categorie) {
        return CategorieViewModel.builder()
                .id(categorie.getId())
                .nom(categorie.getNom())
                .parent(categorie.getParent())
                .build();
    }
}
