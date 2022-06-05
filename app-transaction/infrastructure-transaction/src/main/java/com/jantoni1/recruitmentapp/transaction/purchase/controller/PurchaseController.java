package com.jantoni1.recruitmentapp.transaction.purchase.controller;

import com.jantoni1.recruitmentapp.transaction.purchase.PurchaseFacade;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseCreate;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PurchaseController implements PurchaseClient {

    private final PurchaseFacade facade;

    @Override
    public Purchase update(@PathVariable(value = "id") UUID id, PurchaseUpdate update) {
        return facade.update(id, update);
    }

    @Override
    public Purchase create(PurchaseCreate create) {
        return facade.create(create);
    }

}
