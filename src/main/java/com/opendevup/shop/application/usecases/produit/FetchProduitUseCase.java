package com.opendevup.shop.application.usecases.produit;

import com.opendevup.shop.application.gateways.ProduitDsGateway;
import com.opendevup.shop.application.presenters.produit.ProduitOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.Produit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FetchProduitUseCase implements UseCase<Long> {

    private final ProduitDsGateway produitDsGateway;
    private final ProduitOutputBoundary presenter;

    @Override
    public void execute(Long id) {
        Mono<Produit> response = produitDsGateway.findById(id);
        presenter.present(response);
    }
}
