package com.opendevup.shop.adapters.persistence.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProduitRepository extends JpaRepository<ProduitEntity, Long> {
}
