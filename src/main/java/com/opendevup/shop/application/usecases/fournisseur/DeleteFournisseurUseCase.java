package com.opendevup.shop.application.usecases.fournisseur;

import com.opendevup.shop.application.gateways.FournisseurDsGateway;
import com.opendevup.shop.application.presenters.DeleteOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteFournisseurUseCase implements UseCase<Long> {

    private final FournisseurDsGateway fournisseurDsGateway;
    private final DeleteOutputBoundary presenter;

    @Override
    public void execute(Long id) {
        Mono<Void> response = fournisseurDsGateway.delete(id);
        presenter.present(response);
    }
}
