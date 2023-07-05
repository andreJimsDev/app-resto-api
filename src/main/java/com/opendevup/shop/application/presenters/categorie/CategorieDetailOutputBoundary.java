package com.opendevup.shop.application.presenters.categorie;

import com.opendevup.shop.domain.Categorie;

public interface CategorieDetailOutputBoundary {
    CategorieDetailViewModel getViewModel();
    void present(Categorie response);
}
