package com.opendevup.shop.application.presenters.fournisseur;

import com.opendevup.shop.domain.Fournisseur;
import reactor.core.publisher.Flux;

public interface FournisseursOutputBoundary {
    Flux<FournisseurViewModel> getViewModel();
    void present(Flux<Fournisseur> response);
}
