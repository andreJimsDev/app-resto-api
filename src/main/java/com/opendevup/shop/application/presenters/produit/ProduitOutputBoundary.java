package com.opendevup.shop.application.presenters.produit;

import com.opendevup.shop.domain.Produit;
import reactor.core.publisher.Mono;

public interface ProduitOutputBoundary {
    Mono<ProduitViewModel> getViewModel();
    void present(Mono<Produit> response);
}
