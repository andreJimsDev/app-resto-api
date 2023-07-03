package com.opendevup.shop.application.presenters.produit;

import com.opendevup.shop.domain.Produit;
import reactor.core.publisher.Flux;

public interface ProduitsOutputBoundary {
    Flux<ProduitViewModel> getViewModel();
    void present(Flux<Produit> response);
}
