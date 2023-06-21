package com.opendevup.shop.application.gateways.repositories;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BaseRepository <T>{
    Mono<T> save(T t);
    Flux<T> findAll();
    Mono<Void> delete(Long id);
    Mono<T> findById(Long id);
}
