package com.opendevup.shop.application.gateways;

import com.opendevup.shop.domain.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface FournisseurDsGateway {
    Fournisseur save(Fournisseur fournisseur);
    List<Fournisseur> findAll();

    void delete(Long id);

    Optional<Fournisseur> findById(Long id);
}
