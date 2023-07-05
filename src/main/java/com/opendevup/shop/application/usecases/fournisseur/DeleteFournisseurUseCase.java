package com.opendevup.shop.application.usecases.fournisseur;

import com.opendevup.shop.application.gateways.FournisseurDsGateway;
import com.opendevup.shop.application.usecases.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteFournisseurUseCase implements UseCase<Long> {

    private final FournisseurDsGateway fournisseurDsGateway;
    

    @Override
    public void execute(Long id) {
        fournisseurDsGateway.delete(id);
    }
}
