package com.opendevup.shop.application.presenters;

import reactor.core.publisher.Mono;

public interface DeleteOutputBoundary {
    Mono<Void> getViewModel();
    void present(Mono<Void> response);
}
