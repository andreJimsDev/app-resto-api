package com.opendevup.shop.application.presenters.categorie;

import com.opendevup.shop.domain.Categorie;

import java.util.List;

public interface CategoriesOutputBoundary {
    List<CategorieViewModel> getViewModel();
    void present(List<Categorie> response);
}
