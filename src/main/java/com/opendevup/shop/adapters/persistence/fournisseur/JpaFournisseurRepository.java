package com.opendevup.shop.adapters.persistence.fournisseur;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface JpaFournisseurRepository extends R2dbcRepository<FournisseurEntity, Long> {
}
