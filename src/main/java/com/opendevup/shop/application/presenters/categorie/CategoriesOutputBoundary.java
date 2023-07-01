package com.opendevup.shop.application.presenters.categorie;

import com.opendevup.shop.domain.Categorie;
import reactor.core.publisher.Flux;

public interface CategoriesOutputBoundary {
    Flux<CategorieViewModel> getViewModel();
    void present(Flux<Categorie> response);
}
