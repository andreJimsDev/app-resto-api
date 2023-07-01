package com.opendevup.shop.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Fournisseur {
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
