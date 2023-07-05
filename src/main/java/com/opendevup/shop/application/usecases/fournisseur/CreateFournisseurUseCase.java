package com.opendevup.shop.application.usecases.fournisseur;

import com.opendevup.shop.application.gateways.FournisseurDsGateway;
import com.opendevup.shop.application.presenters.fournisseur.FournisseurOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.Fournisseur;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateFournisseurUseCase implements UseCase<CreateFournisseurRequest> {

    private final FournisseurDsGateway fournisseurDsGateway;
    private final FournisseurOutputBoundary presenter;

    @Override
    public void execute(CreateFournisseurRequest request) {
        presenter.present(
                fournisseurDsGateway.save(
                        Fournisseur.builder()
                                .nom(request.getNom())
                                .contact(request.getContact())
                                .adresse(request.getAdresse())
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
