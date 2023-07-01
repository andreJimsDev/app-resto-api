package com.opendevup.shop.adapters.persistence.fournisseur;

import com.opendevup.shop.domain.Fournisseur;

public class FournisseurEntityMapper {
    public static Fournisseur toDomain(FournisseurEntity fournisseurEntity) {
        return Fournisseur.builder()
                .id(fournisseurEntity.getId())
                .nom(fournisseurEntity.getNom())
                .contact(fournisseurEntity.getContact())
                .adresse(fournisseurEntity.getAdresse())
                .ville(fournisseurEntity.getVille())
                .codePostal(fournisseurEntity.getCodePostal())
                .tel1(fournisseurEntity.getTel1())
                .tel2(fournisseurEntity.getTel2())
                .fax(fournisseurEntity.getFax())
                .numeroCompte(fournisseurEntity.getNumeroCompte())
                .email(fournisseurEntity.getEmail())
                .remarques(fournisseurEntity.getRemarques())
                .numeroTva(fournisseurEntity.getNumeroTva())
                .build();
    }

    public static FournisseurEntity toEntity(Fournisseur fournisseur) {
        FournisseurEntity fournisseurEntity = new FournisseurEntity();
        fournisseurEntity.setId(fournisseur.getId());
        fournisseurEntity.setNom(fournisseur.getNom());
        fournisseurEntity.setContact(fournisseur.getContact());
        fournisseurEntity.setAdresse(fournisseur.getAdresse());
        fournisseurEntity.setVille(fournisseur.getVille());
        fournisseurEntity.setCodePostal(fournisseur.getCodePostal());
        fournisseurEntity.setTel1(fournisseur.getTel1());
        fournisseurEntity.setFax(fournisseur.getFax());
        fournisseurEntity.setNumeroCompte(fournisseur.getNumeroCompte());
        fournisseurEntity.setEmail(fournisseur.getEmail());
        fournisseurEntity.setRemarques(fournisseur.getRemarques());
        fournisseurEntity.setNumeroTva(fournisseur.getNumeroTva());
        return fournisseurEntity;
    }
}
