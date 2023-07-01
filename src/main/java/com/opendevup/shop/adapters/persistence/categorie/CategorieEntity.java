package com.opendevup.shop.adapters.persistence.categorie;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "categories")
public class CategorieEntity {
    @Id
    private Long id;
    private String nom;
    private Long parent;
    private int tvaSurPlace;
    private int tvaEmporte;
    private boolean visibleCarte1;
    private boolean visibleCarte2;
    private int ordre;
}
