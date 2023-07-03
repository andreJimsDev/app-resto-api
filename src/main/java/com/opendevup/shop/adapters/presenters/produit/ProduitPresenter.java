package com.opendevup.shop.adapters.presenters.produit;

import com.opendevup.shop.application.presenters.produit.ProduitOutputBoundary;
import com.opendevup.shop.application.presenters.produit.ProduitViewModel;
import com.opendevup.shop.domain.Produit;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProduitPresenter extends BaseProduit implements ProduitOutputBoundary {

    private Mono<ProduitViewModel> viewModel;

    @Override
    public Mono<ProduitViewModel> getViewModel() {
        return viewModel;
    }

    @Override
    public void present(Mono<Produit> response) {
        viewModel = response.map(this::mapToProduitViewModel);
    }
}
