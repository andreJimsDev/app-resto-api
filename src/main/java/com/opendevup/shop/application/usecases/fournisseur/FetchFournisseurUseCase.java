package com.opendevup.shop.application.usecases.fournisseur;

import com.opendevup.shop.application.gateways.FournisseurDsGateway;
import com.opendevup.shop.application.presenters.fournisseur.FournisseurOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.Fournisseur;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FetchFournisseurUseCase implements UseCase<Long> {

    private final FournisseurDsGateway fournisseurDsGateway;
    private final FournisseurOutputBoundary presenter;

    @Override
    public void execute(Long id) {
        Optional<Fournisseur> response = fournisseurDsGateway.findById(id);
        if(response.isPresent())
            presenter.present(response.get());
    }
}
