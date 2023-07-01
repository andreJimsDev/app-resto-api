package com.opendevup.shop.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Categorie {
    private Long id;
    private String nom;
    private Long parent;
    private int tvaSurPlace;
    private int tvaEmporte;
    private boolean visibleCarte1;
    private boolean visibleCarte2;
    private int ordre;

    public boolean idValid() {
        return id != null && id > 0;
    }
}
