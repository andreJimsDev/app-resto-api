package com.opendevup.shop.adapters.presenters.produit;

import com.opendevup.shop.application.presenters.produit.ProduitOutputBoundary;
import com.opendevup.shop.application.presenters.produit.ProduitViewModel;
import com.opendevup.shop.domain.Produit;
import org.springframework.stereotype.Service;

@Service
public class ProduitPresenter extends BaseProduit implements ProduitOutputBoundary {

    private ProduitViewModel viewModel;

    @Override
    public ProduitViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void present(Produit response) {
        viewModel = mapToProduitViewModel(response);
    }
}
