package com.opendevup.shop.application.presenters.fournisseur;

import com.opendevup.shop.domain.Fournisseur;

import java.util.List;

public interface FournisseursOutputBoundary {
    List<FournisseurViewModel> getViewModel();
    void present(List<Fournisseur> response);
}
