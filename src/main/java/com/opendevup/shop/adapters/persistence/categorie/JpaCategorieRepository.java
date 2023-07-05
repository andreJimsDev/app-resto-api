package com.opendevup.shop.adapters.persistence.categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaCategorieRepository extends JpaRepository<CategorieEntity, Long> {
    List<CategorieEntity> findByParent(Long parent);
    List<CategorieEntity> findByParentIsNull();
}
