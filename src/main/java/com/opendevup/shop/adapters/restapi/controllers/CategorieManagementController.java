package com.opendevup.shop.adapters.restapi.controllers;

import com.github.javafaker.Faker;
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

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Validated
public class CategorieManagementController {

    private final CreateCategorieUseCase createCategorieUseCase;
    private final UpdateCategorieUseCase updateCategorieUseCase;
    private final DeleteCategorieUseCase deleteCategorieUseCase;
    private final FetchCategorieUseCase fetchCategorieUseCase;
    private final FetchCategoriesUseCase fetchCategoriesUseCase;
    private final CategorieOutputBoundary categoriePresenter;
    private final CategoriesOutputBoundary categoriesPresenter;
    private final CategorieDetailOutputBoundary categorieDetailPresenter;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    public CategorieViewModel create(@RequestBody CreateCategorieRequest request) {
        createCategorieUseCase.execute(request);
        return categoriePresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("")
    public CategorieViewModel update(@RequestBody UpdateCategorieRequest request) {
        updateCategorieUseCase.execute(request);
        return categoriePresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        deleteCategorieUseCase.execute(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public CategorieDetailViewModel getById(@PathVariable("id") Long id) {
        fetchCategorieUseCase.execute(id);
        return categorieDetailPresenter.getViewModel();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public List<CategorieViewModel> getAll(@RequestParam(value = "parent", required = false) Long parent) {
        fetchCategoriesUseCase.execute(parent);
        return categoriesPresenter.getViewModel();
    }

    @GetMapping("/init")
    public String initData() {
        int i = 0;
        Faker faker = new Faker();
        while (i < 6) {
            createCategorieUseCase.execute(
                    CreateCategorieRequest.builder()
                            .nom(faker.food().dish())
                            .build()
            );
            i++;
        }
        return "init categorie done!";
    }
}
