package com.opendevup.shop.adapters.presenters.categorie;

import com.opendevup.shop.application.presenters.categorie.CategorieViewModel;
import com.opendevup.shop.application.presenters.categorie.CategoriesOutputBoundary;
import com.opendevup.shop.domain.Categorie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesPresenter extends BaseCategorie implements CategoriesOutputBoundary {

    private List<CategorieViewModel> viewModel;

    @Override
    public List<CategorieViewModel> getViewModel() {
        return viewModel;
    }

    @Override
    public void present(List<Categorie> response) {
        viewModel = response
                .stream()
                .map(this::mapToCategorieViewModel)
                .collect(Collectors.toList());
    }
}
