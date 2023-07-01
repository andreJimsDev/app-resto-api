package com.opendevup.shop.application.presenters.categorie;

import com.opendevup.shop.domain.Categorie;
import reactor.core.publisher.Mono;

public interface CategorieDetailOutputBoundary {
    Mono<CategorieDetailViewModel> getViewModel();
    void present(Mono<Categorie> response);
}
