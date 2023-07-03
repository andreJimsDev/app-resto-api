package com.opendevup.shop.application.usecases.produit;

import com.opendevup.shop.application.gateways.ProduitDsGateway;
import com.opendevup.shop.application.presenters.DeleteOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteProduitUseCase implements UseCase<Long> {

    private final ProduitDsGateway produitDsGateway;
    private final DeleteOutputBoundary presenter;

    @Override
    public void execute(Long id) {
        Mono<Void> response = produitDsGateway.delete(id);
        presenter.present(response);
    }
}
