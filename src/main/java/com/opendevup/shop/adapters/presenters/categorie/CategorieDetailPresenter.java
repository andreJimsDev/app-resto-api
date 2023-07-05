package com.opendevup.shop.adapters.presenters.categorie;

import com.opendevup.shop.application.presenters.categorie.CategorieDetailOutputBoundary;
import com.opendevup.shop.application.presenters.categorie.CategorieDetailViewModel;
import com.opendevup.shop.domain.Categorie;
import org.springframework.stereotype.Service;

@Service
public class CategorieDetailPresenter extends BaseCategorie implements CategorieDetailOutputBoundary {

    private CategorieDetailViewModel viewModel;

    @Override
    public CategorieDetailViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void present(Categorie response) {
        viewModel = mapToCategorieDetailViewModel(response);
    }
}
