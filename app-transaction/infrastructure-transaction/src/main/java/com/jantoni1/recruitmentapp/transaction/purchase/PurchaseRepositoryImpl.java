package com.jantoni1.recruitmentapp.transaction.purchase;

import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;
import com.jantoni1.recruitmentapp.transaction.purchase.exception.PurchaseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Component
@Transactional
@RequiredArgsConstructor
public class PurchaseRepositoryImpl implements PurchaseRepository {

    private final PurchaseEntityMapper mapper;

    private final PurchaseEntityRepository repository;

    @Override
    public Optional<Purchase> findById(UUID id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Caching(evict = {
            @CacheEvict(allEntries = true, value = {
                    "customer-purchases-three-months"
            }),
    })
    @Override
    public Purchase create(@Valid() Purchase model) {
        return mapper.toDto(repository.save(mapper.toEntity(model)));
    }

    @Caching(evict = {
            @CacheEvict(allEntries = true, value = {
                    "customer-purchases-three-months"
            }),
    })
    @Override
    public Purchase update(UUID id, @Valid() Purchase model) {
        return mapper.toDto(mapper.applyChanges(getOneEntity(id), model));
    }

    private PurchaseEntity getOneEntity(UUID id) {
        return repository.findById(id).orElseThrow(PurchaseNotFoundException.ofId(id));
    }
}
