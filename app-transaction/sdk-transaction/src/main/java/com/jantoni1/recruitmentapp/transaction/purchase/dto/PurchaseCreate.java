package com.jantoni1.recruitmentapp.transaction.purchase.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class PurchaseCreate implements Serializable {

    @NotNull
    private UUID customerId;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false, message = "Purchase amount must be a positive number")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal amount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private LocalDateTime purchaseDate;
}
