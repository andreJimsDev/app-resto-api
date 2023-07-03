package com.opendevup.shop.adapters.persistence.produit;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface JpaProduitRepository extends R2dbcRepository<ProduitEntity, Long> {
}
