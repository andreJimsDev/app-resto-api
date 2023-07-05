package com.opendevup.shop.application.usecases.fournisseur;

import com.opendevup.shop.application.gateways.FournisseurDsGateway;
import com.opendevup.shop.application.presenters.fournisseur.FournisseurOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.Fournisseur;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateFournisseurUseCase implements UseCase<UpdateFournisseurRequest> {

    private final FournisseurDsGateway updateFournisseurRequestDsGateway;
    private final FournisseurOutputBoundary presenter;

    @Override
    public void execute(UpdateFournisseurRequest request) {
        presenter.present(
                updateFournisseurRequestDsGateway.save(
                        Fournisseur.builder()
                                .id(request.getId())
                                .nom(request.getNom())
                                .adresse(request.getAdresse())
                                .contact(request.getContact())
                                .ville(request.getVille())
                                .codePostal(request.getCodePostal())
                                .tel1(request.getTel1())
                                .tel2(request.getTel2())
                                .fax(request.getFax())
                                .numeroCompte(request.getNumeroCompte())
                                .email(request.getEmail())
                                .remarques(request.getRemarques())
                                .numeroTva(request.getNumeroTva())
                                .build()
                )
        );
    }
}
