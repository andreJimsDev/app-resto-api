package com.opendevup.shop.application.gateways;

import com.opendevup.shop.domain.Categorie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategorieDsGateway {
    Mono<Categorie> save(Categorie categorie);
    Flux<Categorie> findAll();
    Mono<Long> count();

    Mono<Void> delete(Long id);

    Mono<Categorie> findById(Long id);
}
