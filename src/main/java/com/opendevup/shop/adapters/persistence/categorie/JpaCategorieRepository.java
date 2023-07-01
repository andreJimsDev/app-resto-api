package com.opendevup.shop.adapters.persistence.categorie;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface JpaCategorieRepository extends R2dbcRepository<CategorieEntity, Long> {
}
