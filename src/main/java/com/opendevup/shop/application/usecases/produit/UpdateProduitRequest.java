package com.opendevup.shop.application.usecases.produit;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@With
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateProduitRequest {
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
    private Long categorieId;
    private Long fournisseurId;
}
