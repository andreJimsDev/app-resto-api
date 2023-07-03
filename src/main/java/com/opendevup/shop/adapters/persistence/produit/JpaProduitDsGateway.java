package com.opendevup.shop.adapters.persistence.produit;

import com.opendevup.shop.application.gateways.ProduitDsGateway;
import com.opendevup.shop.domain.Produit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class JpaProduitDsGateway implements ProduitDsGateway {

    private final JpaProduitRepository jpaProduitRepository;

    @Override
    public Mono<Produit> save(Produit produit) {
        return jpaProduitRepository.save(
                ProduitEntityMapper.toEntity(produit)
        ).map(ProduitEntityMapper::toDomain);
    }

    @Override
    public Flux<Produit> findAll() {
        return jpaProduitRepository.findAll()
                .map(ProduitEntityMapper::toDomain);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return jpaProduitRepository.deleteById(id);
    }

    @Override
    public Mono<Produit> findById(Long id) {
        return jpaProduitRepository.findById(id)
                .map(ProduitEntityMapper::toDomain);
    }
}
