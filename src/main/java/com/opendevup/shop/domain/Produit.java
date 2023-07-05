package com.opendevup.shop.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Produit {
    private Long id;
    private String designation;
    private Double prixVente;
    private Double prixEmporte;
    private Double prixAchat;
    private int qteStock;
    private int qteMin;
    private String refArticleFournisseur;
    private boolean demandeCuisson;
    private boolean demandeAccompagnement;
    private boolean gererStock;
    private Categorie categorie;
    private Fournisseur fournisseur;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
