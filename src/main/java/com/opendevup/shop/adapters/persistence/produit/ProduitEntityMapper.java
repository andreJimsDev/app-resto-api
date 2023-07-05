package com.opendevup.shop.adapters.persistence.produit;

import com.opendevup.shop.adapters.persistence.categorie.CategorieEntityMapper;
import com.opendevup.shop.adapters.persistence.fournisseur.FournisseurEntityMapper;
import com.opendevup.shop.domain.Produit;

public class ProduitEntityMapper {
    public static Produit toDomain(ProduitEntity produitEntity) {
        return Produit.builder()
                .id(produitEntity.getId())
                .designation(produitEntity.getDesignation())
                .prixVente(produitEntity.getPrixVente())
                .prixEmporte(produitEntity.getPrixEmporte())
                .prixAchat(produitEntity.getPrixAchat())
                .qteStock(produitEntity.getQteStock())
                .qteMin(produitEntity.getQteMin())
                .refArticleFournisseur(produitEntity.getRefArticleFournisseur())
                .demandeCuisson(produitEntity.isDemandeCuisson())
                .demandeAccompagnement(produitEntity.isDemandeAccompagnement())
                .gererStock(produitEntity.isGererStock())
                .categorie(CategorieEntityMapper.toDomain(produitEntity.getCategorie()))
                .fournisseur(FournisseurEntityMapper.toDomain(produitEntity.getFournisseur()))
                .createdAt(produitEntity.getCreatedAt())
                .updatedAt(produitEntity.getUpdatedAt())
                .build();
    }

    public static ProduitEntity toEntity(Produit produit) {
        return ProduitEntity.builder()
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
                .categorie(CategorieEntityMapper.toEntity(produit.getCategorie()))
                .fournisseur(FournisseurEntityMapper.toEntity(produit.getFournisseur()))
                .createdAt(produit.getCreatedAt())
                .updatedAt(produit.getUpdatedAt())
                .build();
    }
}
