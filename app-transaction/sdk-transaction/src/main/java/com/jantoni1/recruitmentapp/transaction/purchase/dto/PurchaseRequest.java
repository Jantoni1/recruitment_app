package com.jantoni1.recruitmentapp.transaction.purchase.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PurchaseRequest implements Serializable {
    private LocalDate from;
    private LocalDate to;
}
