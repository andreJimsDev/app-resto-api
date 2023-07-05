package com.opendevup.shop.application.gateways;

import com.opendevup.shop.domain.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitDsGateway {
    Produit save(Produit produit);
    List<Produit> findAll();

    void delete(Long id);

    Optional<Produit> findById(Long id);
}
