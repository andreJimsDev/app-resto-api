package com.opendevup.shop.adapters.persistence.produit;

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
                .categorieId(produitEntity.getCategorieId())
                .fournisseurId(produitEntity.getFournisseurId())
                .createdAt(produitEntity.getCreatedAt())
                .updatedAt(produitEntity.getUpdatedAt())
                .build();
    }

    public static ProduitEntity toEntity(Produit produit) {
        ProduitEntity produitEntity = new ProduitEntity();
        produitEntity.setId(produit.getId());
        produitEntity.setDesignation(produit.getDesignation());
        produitEntity.setPrixVente(produit.getPrixVente());
        produitEntity.setPrixEmporte(produit.getPrixEmporte());
        produitEntity.setPrixAchat(produit.getPrixAchat());
        produitEntity.setQteStock(produit.getQteStock());
        produitEntity.setQteMin(produit.getQteMin());
        produitEntity.setRefArticleFournisseur(produit.getRefArticleFournisseur());
        produitEntity.setDemandeCuisson(produit.isDemandeCuisson());
        produitEntity.setDemandeAccompagnement(produit.isDemandeAccompagnement());
        produitEntity.setGererStock(produit.isGererStock());
        produitEntity.setCategorieId(produit.getCategorieId());
        produitEntity.setFournisseurId(produit.getFournisseurId());
        produitEntity.setCreatedAt(produit.getCreatedAt());
        produitEntity.setUpdatedAt(produit.getUpdatedAt());
        return produitEntity;
    }
}
