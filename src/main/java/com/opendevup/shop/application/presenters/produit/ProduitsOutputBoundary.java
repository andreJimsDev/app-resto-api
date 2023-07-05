package com.opendevup.shop.application.presenters.produit;

import com.opendevup.shop.domain.Produit;

import java.util.List;

public interface ProduitsOutputBoundary {
    List<ProduitViewModel> getViewModel();
    void present(List<Produit> response);
}
