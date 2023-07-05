package com.opendevup.shop.adapters.presenters.fournisseur;

import com.opendevup.shop.application.presenters.fournisseur.FournisseurViewModel;
import com.opendevup.shop.application.presenters.fournisseur.FournisseursOutputBoundary;
import com.opendevup.shop.domain.Fournisseur;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FournisseursPresenter extends BaseFournisseur implements FournisseursOutputBoundary {

    private List<FournisseurViewModel> viewModel;

    @Override
    public List<FournisseurViewModel> getViewModel() {
        return viewModel;
    }

    @Override
    public void present(List<Fournisseur> response) {
        viewModel = response
                .stream()
                .map(this::mapToFournisseurViewModel)
                .collect(Collectors.toList());
    }
}
