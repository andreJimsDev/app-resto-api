package com.opendevup.shop.adapters.persistence.fournisseur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaFournisseurRepository extends JpaRepository<FournisseurEntity, Long> {
}
