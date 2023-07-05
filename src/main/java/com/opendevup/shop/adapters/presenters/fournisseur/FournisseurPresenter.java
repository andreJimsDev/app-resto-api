package com.opendevup.shop.adapters.presenters.fournisseur;

import com.opendevup.shop.application.presenters.fournisseur.FournisseurOutputBoundary;
import com.opendevup.shop.application.presenters.fournisseur.FournisseurViewModel;
import com.opendevup.shop.domain.Fournisseur;
import org.springframework.stereotype.Service;

@Service
public class FournisseurPresenter extends BaseFournisseur implements FournisseurOutputBoundary {

    private FournisseurViewModel viewModel;

    @Override
    public FournisseurViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void present(Fournisseur response) {
        viewModel = mapToFournisseurViewModel(response);
    }
}
