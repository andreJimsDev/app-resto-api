package com.opendevup.shop.adapters.persistence.categorie;

import com.opendevup.shop.domain.Categorie;

public class CategorieEntityMapper {
    public static Categorie toDomain(CategorieEntity categorieEntity) {
        return Categorie.builder()
                .id(categorieEntity.getId())
                .nom(categorieEntity.getNom())
                .ordre(categorieEntity.getOrdre())
                .tvaEmporte(categorieEntity.getTvaEmporte())
                .tvaSurPlace(categorieEntity.getTvaSurPlace())
                .visibleCarte1(categorieEntity.isVisibleCarte1())
                .visibleCarte2(categorieEntity.isVisibleCarte2())
                .parent(categorieEntity.getParent())
                .build();
    }

    public static CategorieEntity toEntity(Categorie categorie) {
        CategorieEntity categorieEntity = new CategorieEntity();
        categorieEntity.setId(categorie.getId());
        categorieEntity.setNom(categorie.getNom());
        categorieEntity.setOrdre(categorie.getOrdre());
        categorieEntity.setTvaEmporte(categorie.getTvaEmporte());
        categorieEntity.setTvaSurPlace(categorie.getTvaSurPlace());
        categorieEntity.setVisibleCarte1(categorie.isVisibleCarte1());
        categorieEntity.setVisibleCarte2(categorie.isVisibleCarte2());
        categorieEntity.setParent(categorie.getParent());
        return categorieEntity;
    }
}
