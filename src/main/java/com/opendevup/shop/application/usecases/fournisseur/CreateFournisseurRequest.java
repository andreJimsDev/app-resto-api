package com.opendevup.shop.application.usecases.fournisseur;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@With
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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
