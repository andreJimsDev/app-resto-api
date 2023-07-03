package com.opendevup.shop.application.usecases.produit;

import com.opendevup.shop.application.gateways.ProduitDsGateway;
import com.opendevup.shop.application.presenters.produit.ProduitOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.Produit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UpdateProduitUseCase implements UseCase<Mono<UpdateProduitRequest>> {

    private final ProduitDsGateway updateProduitRequestDsGateway;
    private final ProduitOutputBoundary presenter;

    @Override
    public void execute(Mono<UpdateProduitRequest> updateProduitRequest) {
        Mono<Produit> response = updateProduitRequest.flatMap(
                request -> updateProduitRequestDsGateway.save(
                        Produit.builder()
                                .id(request.getId())
                                .designation(request.getDesignation())
                                .prixVente(request.getPrixVente())
                                .prixEmporte(request.getPrixEmporte())
                                .prixAchat(request.getPrixAchat())
                                .qteStock(request.getQteStock())
                                .qteMin(request.getQteMin())
                                .refArticleFournisseur(request.getRefArticleFournisseur())
                                .demandeCuisson(request.isDemandeCuisson())
                                .demandeAccompagnement(request.isDemandeAccompagnement())
                                .gererStock(request.isGererStock())
                                .categorieId(request.getCategorieId())
                                .fournisseurId(request.getFournisseurId())
                                .updatedAt(LocalDate.now())
                                .build()
                )
        );
        presenter.present(response);
    }
}
