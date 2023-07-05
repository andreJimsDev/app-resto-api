package com.opendevup.shop.application.presenters.produit;

import com.opendevup.shop.domain.Produit;

public interface ProduitOutputBoundary {
    ProduitViewModel getViewModel();
    void present(Produit response);
}
