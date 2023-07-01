package com.opendevup.shop.application.usecases.fournisseur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateFournisseurRequest {
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
