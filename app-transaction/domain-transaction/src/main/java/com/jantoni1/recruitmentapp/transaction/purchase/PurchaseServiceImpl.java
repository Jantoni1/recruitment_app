package com.jantoni1.recruitmentapp.transaction.purchase;

import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseCreate;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseUpdate;
import com.jantoni1.recruitmentapp.transaction.purchase.exception.PurchaseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseMapper mapper;

    private final PurchaseRepository repository;

    @Override
    public Optional<Purchase> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Purchase getOne(UUID id) {
        return findById(id).orElseThrow(PurchaseNotFoundException.ofId(id));
    }

    @Override
    public Purchase create(PurchaseCreate model) {
        return repository.create(mapper.toDto(model));
    }

    @Override
    public Purchase update(UUID id, PurchaseUpdate model) {
        final var one = getOne(id);
        return repository.update(id, mapper.applyChanges(one, model));
    }

}
