package com.jantoni1.recruitmentapp.transaction.purchase;

import com.jantoni1.recruitmentapp.transaction.customer.CustomerFacade;
import com.jantoni1.recruitmentapp.transaction.customer.exception.CustomerNotFoundException;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@RequiredArgsConstructor
@Slf4j
@Component
@Validated
class PurchaseCreator {
    private final PurchaseService service;

    private final CustomerFacade customerFacade;

    public Purchase execute(@Valid() PurchaseCreate create) {
        log.info("Executed PurchaseCreator with payload {}", create);
        customerFacade.findById(create.getCustomerId())
                .orElseThrow(CustomerNotFoundException.ofId(create.getCustomerId()));
        return service.create(create);
    }
}
