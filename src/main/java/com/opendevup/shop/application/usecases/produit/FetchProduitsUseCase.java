package com.opendevup.shop.application.usecases.produit;

import com.opendevup.shop.application.gateways.ProduitDsGateway;
import com.opendevup.shop.application.presenters.produit.ProduitsOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.Produit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchProduitsUseCase implements UseCase<String> {

    private final ProduitDsGateway produitDsGateway;
    private final ProduitsOutputBoundary presenter;

    @Override
    public void execute(String request) {
        List<Produit> response = produitDsGateway.findAll();
        presenter.present(response);
    }
}
