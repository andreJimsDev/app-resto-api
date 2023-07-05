package com.opendevup.shop.adapters.restapi.controllers;

import com.github.javafaker.Faker;
import com.opendevup.shop.application.presenters.produit.ProduitOutputBoundary;
import com.opendevup.shop.application.presenters.produit.ProduitViewModel;
import com.opendevup.shop.application.presenters.produit.ProduitsOutputBoundary;
import com.opendevup.shop.application.usecases.produit.CreateProduitRequest;
import com.opendevup.shop.application.usecases.produit.CreateProduitUseCase;
import com.opendevup.shop.application.usecases.produit.DeleteProduitUseCase;
import com.opendevup.shop.application.usecases.produit.FetchProduitUseCase;
import com.opendevup.shop.application.usecases.produit.FetchProduitsUseCase;
import com.opendevup.shop.application.usecases.produit.UpdateProduitRequest;
import com.opendevup.shop.application.usecases.produit.UpdateProduitUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
@RequiredArgsConstructor
@Validated
public class ProduitManagementController {

    private final CreateProduitUseCase createProduitUseCase;
    private final UpdateProduitUseCase updateProduitUseCase;
    private final DeleteProduitUseCase deleteProduitUseCase;
    private final FetchProduitUseCase fetchProduitUseCase;
    private final FetchProduitsUseCase fetchProduitsUseCase;
    private final ProduitOutputBoundary produitPresenter;
    private final ProduitsOutputBoundary produitsPresenter;

    @PostMapping("")
    public ProduitViewModel create(@RequestBody CreateProduitRequest request) {
        createProduitUseCase.execute(request);
        return produitPresenter.getViewModel();
    }

    @PutMapping("")
    public ProduitViewModel update(@RequestBody UpdateProduitRequest request) {
        updateProduitUseCase.execute(request);
        return produitPresenter.getViewModel();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        deleteProduitUseCase.execute(id);
    }

    @GetMapping("/{id}")
    public ProduitViewModel getById(@PathVariable("id") Long id) {
        fetchProduitUseCase.execute(id);
        return produitPresenter.getViewModel();
    }

    @GetMapping("")
    public List<ProduitViewModel> getAll() {
        fetchProduitsUseCase.execute("");
        return produitsPresenter.getViewModel();
    }

    @GetMapping("/init")
    public String initData() {
        int i = 0;
        Faker faker = new Faker();
        while (i < 33) {
            createProduitUseCase.execute(
                    CreateProduitRequest.builder()
                            .designation(faker.food().dish())
                            .prixVente(Double.valueOf(faker.commerce().price(5000, 20000).replace(",",".")))
                            .prixEmporte(Double.valueOf(faker.commerce().price(5000, 20000).replace(",",".")))
                            .prixAchat(Double.valueOf(faker.commerce().price(5000, 20000).replace(",",".")))
                            .qteStock(10)
                            .qteMin(10)
                            .refArticleFournisseur("REF"+i)
                            .categorieId((long)faker.number().numberBetween(1, 6))
                            .fournisseurId((long)faker.number().numberBetween(1, 6))
                            .build()
            );
            i++;
        }
        return "init produit done!";
    }
}
