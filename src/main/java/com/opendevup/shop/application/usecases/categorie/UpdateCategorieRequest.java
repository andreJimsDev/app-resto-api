package com.opendevup.shop.application.usecases.categorie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategorieRequest {
    private Long id;
    private String nom;
    private Long parent;
    private int tvaSurPlace;
    private int tvaEmporte;
    private boolean visibleCarte1;
    private boolean visibleCarte2;
    private int order;
}
