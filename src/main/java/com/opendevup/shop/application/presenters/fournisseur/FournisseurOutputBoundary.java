package com.opendevup.shop.application.presenters.fournisseur;

import com.opendevup.shop.domain.Fournisseur;

public interface FournisseurOutputBoundary {
    FournisseurViewModel getViewModel();
    void present(Fournisseur response);
}
