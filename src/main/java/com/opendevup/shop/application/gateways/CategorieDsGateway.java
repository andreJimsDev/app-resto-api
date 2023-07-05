package com.opendevup.shop.application.gateways;

import com.opendevup.shop.domain.Categorie;

import java.util.List;
import java.util.Optional;

public interface CategorieDsGateway {
    Categorie save(Categorie categorie);
    List<Categorie> findAll();
    List<Categorie> findByParent(Long parent);
    Long count();
    void delete(Long id);
    Optional<Categorie> findById(Long id);
}
