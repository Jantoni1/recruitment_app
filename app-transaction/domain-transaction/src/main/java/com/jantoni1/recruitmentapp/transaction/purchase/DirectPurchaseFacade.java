package com.jantoni1.recruitmentapp.transaction.purchase;

import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseCreate;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
class DirectPurchaseFacade implements PurchaseFacade {

    private final PurchaseService service;

    private final PurchaseCreator createUseCase;

    private final PurchaseUpdater updateUseCase;

    @Override
    public Optional<Purchase> findById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Purchase getOne(UUID id) {
        return service.getOne(id);
    }

    @Override
    public Purchase create(PurchaseCreate model) {
        return createUseCase.execute(model);
    }

    @Override
    public Purchase update(UUID id, PurchaseUpdate model) {
        return updateUseCase.execute(id, model);
    }

}
