package com.opendevup.shop.adapters.restapi.controllers;

import com.github.javafaker.Faker;
import com.opendevup.shop.application.presenters.fournisseur.FournisseurOutputBoundary;
import com.opendevup.shop.application.presenters.fournisseur.FournisseurViewModel;
import com.opendevup.shop.application.presenters.fournisseur.FournisseursOutputBoundary;
import com.opendevup.shop.application.usecases.fournisseur.CreateFournisseurRequest;
import com.opendevup.shop.application.usecases.fournisseur.CreateFournisseurUseCase;
import com.opendevup.shop.application.usecases.fournisseur.DeleteFournisseurUseCase;
import com.opendevup.shop.application.usecases.fournisseur.FetchFournisseurUseCase;
import com.opendevup.shop.application.usecases.fournisseur.FetchFournisseursUseCase;
import com.opendevup.shop.application.usecases.fournisseur.UpdateFournisseurRequest;
import com.opendevup.shop.application.usecases.fournisseur.UpdateFournisseurUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/fournisseurs")
@RequiredArgsConstructor
@Validated
public class FournisseurManagementController {

    private final CreateFournisseurUseCase createFournisseurUseCase;
    private final UpdateFournisseurUseCase updateFournisseurUseCase;
    private final DeleteFournisseurUseCase deleteFournisseurUseCase;
    private final FetchFournisseurUseCase fetchFournisseurUseCase;
    private final FetchFournisseursUseCase fetchFournisseursUseCase;
    private final FournisseurOutputBoundary fournisseurPresenter;
    private final FournisseursOutputBoundary fournisseursPresenter;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    public FournisseurViewModel create(@RequestBody CreateFournisseurRequest request) {
        createFournisseurUseCase.execute(request);
        return fournisseurPresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("")
    public FournisseurViewModel update(@RequestBody UpdateFournisseurRequest request) {
        updateFournisseurUseCase.execute(request);
        return fournisseurPresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        deleteFournisseurUseCase.execute(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public FournisseurViewModel getById(@PathVariable("id") Long id) {
        fetchFournisseurUseCase.execute(id);
        return fournisseurPresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public List<FournisseurViewModel> getAll() {
        fetchFournisseursUseCase.execute("");
        return fournisseursPresenter.getViewModel();
    }

    @GetMapping("/init")
    public String initData() {
        int i = 0;
        Faker faker = new Faker();
        while (i < 6) {
            createFournisseurUseCase.execute(CreateFournisseurRequest.builder()
                    .nom(faker.commerce().department())
                    .contact(faker.address().streetName())
                    .adresse(faker.address().streetAddress())
                    .ville(faker.address().city())
                    .codePostal(faker.address().zipCode())
                    .tel1(faker.phoneNumber().phoneNumber())
                    .tel2(faker.phoneNumber().phoneNumber())
                    .fax(faker.phoneNumber().cellPhone())
                    .numeroCompte(faker.finance().iban())
                    .email(faker.internet().emailAddress())
                    .remarques(faker.lorem().sentence())
                    .numeroTva(faker.idNumber().ssnValid())
                    .build());
            i++;
        }
        return "init fournisseur done!";
    }
}
