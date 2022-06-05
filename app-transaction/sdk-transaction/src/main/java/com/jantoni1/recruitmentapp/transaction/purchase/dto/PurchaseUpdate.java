package com.jantoni1.recruitmentapp.transaction.purchase.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class PurchaseUpdate implements Serializable {

    @NotNull
    private UUID customerId;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = false, message = "Purchase amount must be a positive number")
    private BigDecimal amount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private LocalDateTime purchaseDate;

}
