package com.opendevup.shop.adapters.persistence.produit;

import com.opendevup.shop.application.gateways.ProduitDsGateway;
import com.opendevup.shop.domain.Produit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class JpaProduitDsGateway implements ProduitDsGateway {

    private final JpaProduitRepository jpaProduitRepository;

    @Override
    public Produit save(Produit produit) {
        return ProduitEntityMapper.toDomain(
                jpaProduitRepository.save(
                        ProduitEntityMapper.toEntity(produit)
                )
        );
    }

    @Override
    public List<Produit> findAll() {
        return jpaProduitRepository.findAll()
                .stream()
                .map(ProduitEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        jpaProduitRepository.deleteById(id);
    }

    @Override
    public Optional<Produit> findById(Long id) {
        return jpaProduitRepository.findById(id)
                .map(ProduitEntityMapper::toDomain);
    }
}
