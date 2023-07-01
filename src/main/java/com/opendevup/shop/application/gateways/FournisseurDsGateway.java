package com.opendevup.shop.application.gateways;

import com.opendevup.shop.domain.Fournisseur;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FournisseurDsGateway {
    Mono<Fournisseur> save(Fournisseur fournisseur);
    Flux<Fournisseur> findAll();

    Mono<Void> delete(Long id);

    Mono<Fournisseur> findById(Long id);
}
