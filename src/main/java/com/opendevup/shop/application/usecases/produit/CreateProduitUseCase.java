package com.opendevup.shop.application.usecases.produit;

import com.opendevup.shop.application.gateways.CategorieDsGateway;
import com.opendevup.shop.application.gateways.FournisseurDsGateway;
import com.opendevup.shop.application.gateways.ProduitDsGateway;
import com.opendevup.shop.application.presenters.produit.ProduitOutputBoundary;
import com.opendevup.shop.application.usecases.UseCase;
import com.opendevup.shop.domain.Categorie;
import com.opendevup.shop.domain.Fournisseur;
import com.opendevup.shop.domain.Produit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CreateProduitUseCase implements UseCase<CreateProduitRequest> {

    private final ProduitDsGateway produitDsGateway;
    private final CategorieDsGateway categorieDsGateway;
    private final FournisseurDsGateway fournisseurDsGateway;
    private final ProduitOutputBoundary presenter;

    @Override
    public void execute(CreateProduitRequest request) {
        Categorie categorie = categorieDsGateway.findById(
                request.getCategorieId()
        ).orElseThrow(() -> new RuntimeException("Categorie is not found"));
        Fournisseur fournisseur = null;
        if (request.getFournisseurId() != null)
            fournisseur = fournisseurDsGateway.findById(
                    request.getFournisseurId()
            ).orElseThrow(() -> new RuntimeException("Fournisseur is not found"));
        presenter.present(
                produitDsGateway.save(
                        Produit.builder()
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
                                .categorie(categorie)
                                .fournisseur(fournisseur)
                                .createdAt(LocalDate.now())
                                .build()
                )
        );
    }
}
