package com.opendevup.shop.application.usecases.fournisseur;

import com.opendevup.shop.application.gateways.FournisseurDsGateway;
import com.opendevup.shop.application.presenters.fournisseur.FournisseurOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.Fournisseur;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateFournisseurUseCase implements UseCase<Mono<CreateFournisseurRequest>> {

    private final FournisseurDsGateway fournisseurDsGateway;
    private final FournisseurOutputBoundary presenter;

    @Override
    public void execute(Mono<CreateFournisseurRequest> createFournisseurRequest) {
        Mono<Fournisseur> response = createFournisseurRequest.flatMap(
                request -> fournisseurDsGateway.save(
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
        presenter.present(response);
    }
}
