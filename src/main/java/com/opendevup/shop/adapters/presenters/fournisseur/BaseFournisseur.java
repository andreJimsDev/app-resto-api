package com.opendevup.shop.adapters.presenters.fournisseur;

import com.opendevup.shop.application.presenters.fournisseur.FournisseurViewModel;
import com.opendevup.shop.domain.Fournisseur;

public class BaseFournisseur {
    protected BaseFournisseur() { }

    public FournisseurViewModel mapToFournisseurViewModel(Fournisseur fournisseur) {
        return FournisseurViewModel.builder()
                .id(fournisseur.getId())
                .adresse(fournisseur.getAdresse())
                .nom(fournisseur.getNom())
                .contact(fournisseur.getContact())
                .ville(fournisseur.getVille())
                .codePostal(fournisseur.getCodePostal())
                .tel1(fournisseur.getTel1())
                .tel2(fournisseur.getTel2())
                .fax(fournisseur.getFax())
                .numeroCompte(fournisseur.getNumeroCompte())
                .email(fournisseur.getEmail())
                .remarques(fournisseur.getRemarques())
                .numeroTva(fournisseur.getNumeroTva())
                .build();
    }
}
