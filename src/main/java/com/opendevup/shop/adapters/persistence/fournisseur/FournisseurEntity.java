package com.opendevup.shop.adapters.persistence.fournisseur;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "fournisseurs")
public class FournisseurEntity {
    @Id
    private Long id;
    private String nom;
    private String contact;
    private String adresse;
    private String ville;
    private String codePostal;
    private String tel1;
    private String tel2;
    private String fax;
    private String numeroCompte;
    private String email;
    private String remarques;
    private String numeroTva;
}
