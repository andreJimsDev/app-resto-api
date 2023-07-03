package com.opendevup.shop.application.gateways;

import com.opendevup.shop.domain.Produit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProduitDsGateway {
    Mono<Produit> save(Produit produit);
    Flux<Produit> findAll();

    Mono<Void> delete(Long id);

    Mono<Produit> findById(Long id);
}
