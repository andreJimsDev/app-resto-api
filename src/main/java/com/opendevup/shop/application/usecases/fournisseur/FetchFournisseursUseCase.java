package com.opendevup.shop.application.usecases.fournisseur;

import com.opendevup.shop.application.gateways.FournisseurDsGateway;
import com.opendevup.shop.application.presenters.fournisseur.FournisseursOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FetchFournisseursUseCase implements UseCase<String> {

    private final FournisseurDsGateway fournisseurDsGateway;
    private final FournisseursOutputBoundary presenter;

    @Override
    public void execute(String request) {
        presenter.present(
                fournisseurDsGateway.findAll()
        );
    }
}
