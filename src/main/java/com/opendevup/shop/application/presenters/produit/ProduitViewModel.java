package com.opendevup.shop.application.presenters.produit;

import com.opendevup.shop.domain.Categorie;
import com.opendevup.shop.domain.Fournisseur;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@With
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProduitViewModel {
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
