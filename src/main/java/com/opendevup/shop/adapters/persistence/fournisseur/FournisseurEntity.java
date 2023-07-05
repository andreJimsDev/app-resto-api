package com.opendevup.shop.adapters.persistence.fournisseur;

import com.opendevup.shop.adapters.persistence.produit.ProduitEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
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
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@With
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "fournisseurs")
public class FournisseurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(mappedBy = "fournisseur")
    private Set<ProduitEntity> produitEntities = new HashSet<>();
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
