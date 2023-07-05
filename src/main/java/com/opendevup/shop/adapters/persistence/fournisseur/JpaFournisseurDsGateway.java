package com.opendevup.shop.adapters.persistence.fournisseur;

import com.opendevup.shop.application.gateways.FournisseurDsGateway;
import com.opendevup.shop.domain.Fournisseur;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class JpaFournisseurDsGateway implements FournisseurDsGateway {

    private final JpaFournisseurRepository jpaFournisseurRepository;

    @Override
    public Fournisseur save(Fournisseur fournisseur) {
        return FournisseurEntityMapper.toDomain(
                jpaFournisseurRepository.save(
                        FournisseurEntityMapper.toEntity(fournisseur)
                )
        );
    }

    @Override
    public List<Fournisseur> findAll() {
        return jpaFournisseurRepository.findAll()
                .stream()
                .map(FournisseurEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        jpaFournisseurRepository.deleteById(id);
    }

    @Override
    public Optional<Fournisseur> findById(Long id) {
        return  jpaFournisseurRepository.findById(
                id
        ).map(FournisseurEntityMapper::toDomain);
    }
}
