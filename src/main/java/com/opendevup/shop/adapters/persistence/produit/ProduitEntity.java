package com.opendevup.shop.adapters.persistence.produit;

import com.opendevup.shop.adapters.persistence.categorie.CategorieEntity;
import com.opendevup.shop.adapters.persistence.fournisseur.FournisseurEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@With
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
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
    @ManyToOne
    private CategorieEntity categorie;
    @ManyToOne
    private FournisseurEntity fournisseur;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
