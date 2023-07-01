package com.opendevup.shop.application.presenters.fournisseur;

import com.opendevup.shop.domain.Fournisseur;
import reactor.core.publisher.Mono;

public interface FournisseurOutputBoundary {
    Mono<FournisseurViewModel> getViewModel();
    void present(Mono<Fournisseur> response);
}
