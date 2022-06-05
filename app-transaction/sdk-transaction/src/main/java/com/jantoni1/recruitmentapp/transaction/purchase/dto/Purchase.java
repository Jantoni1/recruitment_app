package com.jantoni1.recruitmentapp.transaction.purchase.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Purchase implements Serializable {

    @With
    private UUID id = UUID.randomUUID();

    private UUID customerId;

    private BigDecimal amount;

    private LocalDateTime purchaseDate;

}
