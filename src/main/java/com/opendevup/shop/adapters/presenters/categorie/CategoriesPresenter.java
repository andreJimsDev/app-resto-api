package com.opendevup.shop.adapters.presenters.categorie;

import com.opendevup.shop.application.presenters.categorie.CategorieViewModel;
import com.opendevup.shop.application.presenters.categorie.CategoriesOutputBoundary;
import com.opendevup.shop.domain.Categorie;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CategoriesPresenter implements CategoriesOutputBoundary {

    private Flux<CategorieViewModel> viewModel;

    @Override
    public Flux<CategorieViewModel> getViewModel() {
        return viewModel;
    }

    @Override
    public void present(Flux<Categorie> response) {
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
