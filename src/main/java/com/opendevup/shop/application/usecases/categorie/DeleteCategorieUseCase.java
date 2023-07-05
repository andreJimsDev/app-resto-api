package com.opendevup.shop.application.usecases.categorie;

import com.opendevup.shop.application.gateways.CategorieDsGateway;
import com.opendevup.shop.application.usecases.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCategorieUseCase implements UseCase<Long> {

    private final CategorieDsGateway categorieDsGateway;
    

    @Override
    public void execute(Long id) {
        categorieDsGateway.delete(id);
    }
}
