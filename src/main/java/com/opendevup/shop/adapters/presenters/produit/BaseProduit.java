package com.opendevup.shop.adapters.presenters.produit;

import com.opendevup.shop.application.presenters.produit.ProduitViewModel;
import com.opendevup.shop.domain.Produit;

public class BaseProduit {
    protected BaseProduit() { }

    public ProduitViewModel mapToProduitViewModel(Produit produit) {
        return ProduitViewModel.builder()
                .id(produit.getId())
                .designation(produit.getDesignation())
                .prixVente(produit.getPrixVente())
                .prixEmporte(produit.getPrixEmporte())
                .prixAchat(produit.getPrixAchat())
                .qteStock(produit.getQteStock())
                .qteMin(produit.getQteMin())
                .refArticleFournisseur(produit.getRefArticleFournisseur())
                .demandeCuisson(produit.isDemandeCuisson())
                .demandeAccompagnement(produit.isDemandeAccompagnement())
                .gererStock(produit.isGererStock())
                .categorie(produit.getCategorie())
                .fournisseur(produit.getFournisseur())
                .createdAt(produit.getCreatedAt())
                .updatedAt(produit.getUpdatedAt())
                .build();
    }
}
