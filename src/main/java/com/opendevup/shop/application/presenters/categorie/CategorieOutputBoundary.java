package com.opendevup.shop.application.presenters.categorie;

import com.opendevup.shop.domain.Categorie;

public interface CategorieOutputBoundary {
    CategorieViewModel getViewModel();
    void present(Categorie response);
}
