package com.opendevup.shop.adapters.restapi.controllers;

import com.github.javafaker.Faker;
import com.opendevup.shop.application.presenters.DeleteOutputBoundary;
import com.opendevup.shop.application.presenters.categorie.CategorieDetailOutputBoundary;
import com.opendevup.shop.application.presenters.categorie.CategorieDetailViewModel;
import com.opendevup.shop.application.presenters.categorie.CategorieOutputBoundary;
import com.opendevup.shop.application.presenters.categorie.CategorieViewModel;
import com.opendevup.shop.application.presenters.categorie.CategoriesOutputBoundary;
import com.opendevup.shop.application.usecases.categorie.CreateCategorieRequest;
import com.opendevup.shop.application.usecases.categorie.CreateCategorieUseCase;
import com.opendevup.shop.application.usecases.categorie.DeleteCategorieUseCase;
import com.opendevup.shop.application.usecases.categorie.FetchCategorieUseCase;
import com.opendevup.shop.application.usecases.categorie.FetchCategoriesUseCase;
import com.opendevup.shop.application.usecases.categorie.UpdateCategorieRequest;
import com.opendevup.shop.application.usecases.categorie.UpdateCategorieUseCase;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Validated
public class CategorieController {

    private final CreateCategorieUseCase createCategorieUseCase;
    private final UpdateCategorieUseCase updateCategorieUseCase;
    private final DeleteCategorieUseCase deleteCategorieUseCase;
    private final FetchCategorieUseCase fetchCategorieUseCase;
    private final FetchCategoriesUseCase fetchCategoriesUseCase;
    private final CategorieOutputBoundary categoriePresenter;
    private final CategoriesOutputBoundary categoriesPresenter;
    private final CategorieDetailOutputBoundary categorieDetailPresenter;
    private final DeleteOutputBoundary deletePresenter;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    public Mono<CategorieViewModel> create(@RequestBody Mono<CreateCategorieRequest> request) {
        createCategorieUseCase.execute(request);
        return categoriePresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("")
    public Mono<CategorieViewModel> update(@RequestBody Mono<UpdateCategorieRequest> request) {
        updateCategorieUseCase.execute(request);
        return categoriePresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        deleteCategorieUseCase.execute(id);
        return deletePresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Mono<CategorieDetailViewModel> getById(@PathVariable("id") Long id) {
        fetchCategorieUseCase.execute(id);
        return categorieDetailPresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public Flux<CategorieViewModel> getAll(@RequestParam(value = "parent", required = false) Long parent) {
        fetchCategoriesUseCase.execute(parent);
        return categoriesPresenter.getViewModel();
    }

    @GetMapping("/init")
    public Mono<String> initData() {
        int i = 0;
        Faker faker = new Faker();
        while (i < 6) {
            createCategorieUseCase.execute(
                    Mono.just(
                            CreateCategorieRequest.builder()
                                    .nom(faker.food().dish())
                                    .build()
                    )
            );
            categoriePresenter.getViewModel().subscribe();
            i++;
        }
        return Mono.just("init categorie done!");
    }
}
