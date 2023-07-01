package com.opendevup.shop.adapters.persistence.categorie;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface JpaCategorieRepository extends R2dbcRepository<CategorieEntity, Long> {
    Flux<CategorieEntity> findByParent(Long parent);
    Flux<CategorieEntity> findByParentIsNull();
}
