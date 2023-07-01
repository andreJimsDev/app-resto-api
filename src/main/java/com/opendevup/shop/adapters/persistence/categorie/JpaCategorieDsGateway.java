package com.opendevup.shop.adapters.persistence.categorie;

import com.opendevup.shop.application.gateways.CategorieDsGateway;
import com.opendevup.shop.domain.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class JpaCategorieDsGateway implements CategorieDsGateway {

    private final JpaCategorieRepository jpaCategorieRepository;

    @Override
    public Mono<Categorie> save(Categorie categorie) {
        return jpaCategorieRepository.save(
                CategorieEntityMapper.toEntity(categorie)
        ).map(CategorieEntityMapper::toDomain);
    }

    @Override
    public Flux<Categorie> findAll() {
        return jpaCategorieRepository.findAll()
                .map(CategorieEntityMapper::toDomain);
    }

    @Override
    public Mono<Long> count() {
        return jpaCategorieRepository.count();
    }

    @Override
    public Mono<Void> delete(Long id) {
        return jpaCategorieRepository.deleteById(id);
    }

    @Override
    public Mono<Categorie> findById(Long id) {
        System.out.println("id : "+id);
        return jpaCategorieRepository.findById(id)
                .map(CategorieEntityMapper::toDomain);
    }
}
