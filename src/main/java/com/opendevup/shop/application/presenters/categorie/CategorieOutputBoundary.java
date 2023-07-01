package com.opendevup.shop.application.presenters.categorie;

import com.opendevup.shop.domain.Categorie;
import reactor.core.publisher.Mono;

public interface CategorieOutputBoundary {
    Mono<CategorieViewModel> getViewModel();
    void present(Mono<Categorie> response);
}
