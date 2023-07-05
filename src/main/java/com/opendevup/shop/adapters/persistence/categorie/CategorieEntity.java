package com.opendevup.shop.adapters.persistence.categorie;

import com.opendevup.shop.adapters.persistence.produit.ProduitEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;
import lombok.experimental.SuperBuilder;

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
@Table(name = "categories")
public class CategorieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Long parent;
    private int tvaSurPlace;
    private int tvaEmporte;
    private boolean visibleCarte1;
    private boolean visibleCarte2;
    private int ordre;
    @OneToMany(mappedBy = "categorie")
    private Set<ProduitEntity> produitEntities = new HashSet<>();
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
