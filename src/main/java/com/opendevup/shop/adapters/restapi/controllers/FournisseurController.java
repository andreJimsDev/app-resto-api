package com.opendevup.shop.adapters.restapi.controllers;

import com.opendevup.shop.application.presenters.DeleteOutputBoundary;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.github.javafaker.Faker;

@RestController
@RequestMapping("/api/fournisseurs")
@RequiredArgsConstructor
@Validated
public class FournisseurController {

    private final CreateFournisseurUseCase createFournisseurUseCase;
    private final UpdateFournisseurUseCase updateFournisseurUseCase;
    private final DeleteFournisseurUseCase deleteFournisseurUseCase;
    private final FetchFournisseurUseCase fetchFournisseurUseCase;
    private final FetchFournisseursUseCase fetchFournisseursUseCase;
    private final FournisseurOutputBoundary fournisseurPresenter;
    private final FournisseursOutputBoundary fournisseursPresenter;
    private final DeleteOutputBoundary deletePresenter;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    public Mono<FournisseurViewModel> create(@RequestBody Mono<CreateFournisseurRequest> request) {
        createFournisseurUseCase.execute(request);
        return fournisseurPresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("")
    public Mono<FournisseurViewModel> update(@RequestBody Mono<UpdateFournisseurRequest> request) {
        updateFournisseurUseCase.execute(request);
        return fournisseurPresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        deleteFournisseurUseCase.execute(id);
        return deletePresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Mono<FournisseurViewModel> getById(@PathVariable("id") Long id) {
        fetchFournisseurUseCase.execute(id);
        return fournisseurPresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public Flux<FournisseurViewModel> getAll() {
        fetchFournisseursUseCase.execute("");
        return fournisseursPresenter.getViewModel();
    }

    @GetMapping("/init")
    public Mono<String> initData() {
        int i = 0;
        Faker faker = new Faker();
        while (i < 6) {
            createFournisseurUseCase.execute(
                    Mono.just(
                            CreateFournisseurRequest.builder()
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
                                    .build()
                    )
            );
            fournisseurPresenter.getViewModel().subscribe();
            i++;
        }
        return Mono.just("init fournisseur done!");
    }
}
