package com.opendevup.shop.adapters.presenters.produit;

import com.opendevup.shop.application.presenters.produit.ProduitViewModel;
import com.opendevup.shop.application.presenters.produit.ProduitsOutputBoundary;
import com.opendevup.shop.domain.Produit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitsPresenter extends BaseProduit implements ProduitsOutputBoundary {

    private List<ProduitViewModel> viewModel;

    @Override
    public List<ProduitViewModel> getViewModel() {
        return viewModel;
    }

    @Override
    public void present(List<Produit> response) {
        viewModel = response
                .stream()
                .map(this::mapToProduitViewModel)
                .collect(Collectors.toList());
    }
}
