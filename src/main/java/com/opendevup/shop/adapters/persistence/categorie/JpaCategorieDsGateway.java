package com.opendevup.shop.adapters.persistence.categorie;

import com.opendevup.shop.application.gateways.CategorieDsGateway;
import com.opendevup.shop.domain.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class JpaCategorieDsGateway implements CategorieDsGateway {

    private final JpaCategorieRepository jpaCategorieRepository;

    @Override
    public Categorie save(Categorie categorie) {
        return CategorieEntityMapper.toDomain(
                jpaCategorieRepository.save(
                        CategorieEntityMapper.toEntity(categorie)
                )
        );
    }

    @Override
    public List<Categorie> findAll() {
        return jpaCategorieRepository.findByParentIsNull()
                .stream()
                .map(CategorieEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Categorie> findByParent(Long parent) {
        return jpaCategorieRepository.findByParent(parent)
                .stream()
                .map(CategorieEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Long count() {
        return jpaCategorieRepository.count();
    }

    @Override
    public void delete(Long id) {
        jpaCategorieRepository.deleteById(id);
    }

    @Override
    public Optional<Categorie> findById(Long id) {
        return jpaCategorieRepository.findById(id)
                .map(CategorieEntityMapper::toDomain);
    }
}
