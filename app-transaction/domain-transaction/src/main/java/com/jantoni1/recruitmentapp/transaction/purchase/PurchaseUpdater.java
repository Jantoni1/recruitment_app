package com.jantoni1.recruitmentapp.transaction.purchase;

import com.jantoni1.recruitmentapp.transaction.customer.CustomerFacade;
import com.jantoni1.recruitmentapp.transaction.customer.exception.CustomerNotFoundException;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseUpdate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Component
@Validated
class PurchaseUpdater {

    private final PurchaseService service;

    private final CustomerFacade customerFacade;

    public Purchase execute(UUID id, @Valid() PurchaseUpdate update) {
        log.info("Executed PurchaseUpdater with payload {}", update);
        customerFacade.findById(update.getCustomerId())
                .orElseThrow(CustomerNotFoundException.ofId(update.getCustomerId()));
        return service.update(id, update);
    }
}
