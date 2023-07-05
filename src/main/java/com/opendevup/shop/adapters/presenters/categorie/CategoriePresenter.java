package com.opendevup.shop.adapters.presenters.categorie;

import com.opendevup.shop.application.presenters.categorie.CategorieOutputBoundary;
import com.opendevup.shop.application.presenters.categorie.CategorieViewModel;
import com.opendevup.shop.domain.Categorie;
import org.springframework.stereotype.Service;

@Service
public class CategoriePresenter extends BaseCategorie implements CategorieOutputBoundary {

    private CategorieViewModel viewModel;

    @Override
    public CategorieViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void present(Categorie response) {
        viewModel = mapToCategorieViewModel(response);
    }
}
