package com.jantoni1.recruitmentapp.transaction.purchase;

import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

interface PurchaseRepository {

    Optional<Purchase> findById(UUID id);

    Purchase create(@Valid() Purchase model);

    Purchase update(UUID id, @Valid() Purchase model);

}
