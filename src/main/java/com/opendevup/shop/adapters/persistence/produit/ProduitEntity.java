package com.opendevup.shop.adapters.persistence.produit;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table(name = "produits")
public class ProduitEntity {
    @Id
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
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
