package com.jantoni1.recruitmentapp.transaction.reward;

import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

class TestPurchaseCreator {

    static Purchase createPurchase(BigDecimal amount) {
        return new Purchase(UUID.randomUUID(), UUID.randomUUID(), amount, LocalDateTime.now());
    }

    static Purchase createPurchase(BigDecimal amount, LocalDateTime date) {
        return new Purchase(UUID.randomUUID(), UUID.randomUUID(), amount, date);
    }

    static Purchase createPurchase(BigDecimal amount, LocalDateTime date, UUID customerId) {
        return new Purchase(UUID.randomUUID(), customerId, amount, date);
    }

}
