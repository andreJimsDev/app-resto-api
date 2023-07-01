package com.opendevup.shop.adapters.presenters.fournisseur;

import com.opendevup.shop.application.presenters.fournisseur.FournisseurOutputBoundary;
import com.opendevup.shop.application.presenters.fournisseur.FournisseurViewModel;
import com.opendevup.shop.domain.Fournisseur;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FournisseurPresenter extends BaseFournisseur implements FournisseurOutputBoundary {

    private Mono<FournisseurViewModel> viewModel;

    @Override
    public Mono<FournisseurViewModel> getViewModel() {
        return viewModel;
    }

    @Override
    public void present(Mono<Fournisseur> response) {
        viewModel = response.map(this::mapToFournisseurViewModel);
    }
}
