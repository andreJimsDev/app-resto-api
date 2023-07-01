package com.opendevup.shop.adapters.presenters.fournisseur;

import com.opendevup.shop.application.presenters.fournisseur.FournisseurViewModel;
import com.opendevup.shop.application.presenters.fournisseur.FournisseursOutputBoundary;
import com.opendevup.shop.domain.Fournisseur;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class FournisseursPresenter extends BaseFournisseur implements FournisseursOutputBoundary {

    private Flux<FournisseurViewModel> viewModel;

    @Override
    public Flux<FournisseurViewModel> getViewModel() {
        return viewModel;
    }

    @Override
    public void present(Flux<Fournisseur> response) {
        viewModel = response.map(this::mapToFournisseurViewModel);
    }
}
