package com.opendevup.shop.application.usecases.produit;

import com.opendevup.shop.application.gateways.ProduitDsGateway;
import com.opendevup.shop.application.usecases.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProduitUseCase implements UseCase<Long> {

    private final ProduitDsGateway produitDsGateway;
    @Override
    public void execute(Long id) {
        produitDsGateway.delete(id);
    }
}
