package com.jantoni1.recruitmentapp.transaction.purchase;

import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseCreate;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseUpdate;

import java.util.Optional;
import java.util.UUID;

public interface PurchaseFacade {

    Optional<Purchase> findById(UUID id);

    Purchase getOne(UUID id);

    Purchase create(PurchaseCreate model);

    Purchase update(UUID id, PurchaseUpdate model);

}
