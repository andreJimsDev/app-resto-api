package com.opendevup.shop.adapters.presenters.categorie;

import com.opendevup.shop.application.presenters.categorie.CategorieDetailViewModel;
import com.opendevup.shop.application.presenters.categorie.CategorieViewModel;
import com.opendevup.shop.domain.Categorie;

public class BaseCategorie {
    protected BaseCategorie() { }

    public CategorieDetailViewModel mapToCategorieDetailViewModel(Categorie categorie) {
        return CategorieDetailViewModel.builder()
                .id(categorie.getId())
                .nom(categorie.getNom())
                .order(categorie.getOrdre())
                .tvaEmporte(categorie.getTvaEmporte())
                .tvaSurPlace(categorie.getTvaSurPlace())
                .visibleCarte1(categorie.isVisibleCarte1())
                .visibleCarte2(categorie.isVisibleCarte2())
                .parent(categorie.getParent())
                .build();
    }

    public CategorieViewModel mapToCategorieViewModel(Categorie categorie) {
        return CategorieViewModel.builder()
                .id(categorie.getId())
                .nom(categorie.getNom())
                .parent(categorie.getParent())
                .build();
    }
}
