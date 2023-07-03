package com.opendevup.shop.adapters.presenters.produit;

import com.opendevup.shop.application.presenters.produit.ProduitViewModel;
import com.opendevup.shop.application.presenters.produit.ProduitsOutputBoundary;
import com.opendevup.shop.domain.Produit;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProduitsPresenter extends BaseProduit implements ProduitsOutputBoundary {

    private Flux<ProduitViewModel> viewModel;

    @Override
    public Flux<ProduitViewModel> getViewModel() {
        return viewModel;
    }

    @Override
    public void present(Flux<Produit> response) {
        viewModel = response.map(this::mapToProduitViewModel);
    }
}
