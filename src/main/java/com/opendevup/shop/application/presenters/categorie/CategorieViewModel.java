package com.opendevup.shop.application.presenters.categorie;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CategorieViewModel {
    private Long id;
    private String nom;
    private Long parent;
}
