package com.opendevup.shop.adapters.persistence.fournisseur;

import com.opendevup.shop.application.gateways.FournisseurDsGateway;
import com.opendevup.shop.domain.Fournisseur;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class JpaFournisseurDsGateway implements FournisseurDsGateway {

    private final JpaFournisseurRepository jpaFournisseurRepository;

    @Override
    public Mono<Fournisseur> save(Fournisseur fournisseur) {
        return jpaFournisseurRepository.save(
                FournisseurEntityMapper.toEntity(fournisseur)
        ).map(FournisseurEntityMapper::toDomain);
    }

    @Override
    public Flux<Fournisseur> findAll() {
        return jpaFournisseurRepository.findAll()
                .map(FournisseurEntityMapper::toDomain);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return jpaFournisseurRepository.deleteById(id);
    }

    @Override
    public Mono<Fournisseur> findById(Long id) {
        return jpaFournisseurRepository.findById(id)
                .map(FournisseurEntityMapper::toDomain);
    }
}
