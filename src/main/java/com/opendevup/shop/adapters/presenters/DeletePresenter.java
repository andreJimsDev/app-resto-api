package com.opendevup.shop.adapters.presenters;

import com.opendevup.shop.application.presenters.DeleteOutputBoundary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeletePresenter implements DeleteOutputBoundary {

    private Mono<Void> viewModel;

    @Override
    public Mono<Void> getViewModel() {
        return viewModel;
    }

    @Override
    public void present(Mono<Void> response) {
        viewModel = response;
    }
}
