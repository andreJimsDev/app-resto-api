package com.opendevup.shop.application.presenters.categorie;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CategorieDetailViewModel {
    private Long id;
    private String nom;
    private Long parent;
    private int tvaSurPlace;
    private int tvaEmporte;
    private boolean visibleCarte1;
    private boolean visibleCarte2;
    private int order;
}
