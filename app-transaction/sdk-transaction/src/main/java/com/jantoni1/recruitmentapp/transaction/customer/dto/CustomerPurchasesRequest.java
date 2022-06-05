package com.jantoni1.recruitmentapp.transaction.customer.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class CustomerPurchasesRequest implements Serializable {
    private LocalDate from;
    private LocalDate to;
}
