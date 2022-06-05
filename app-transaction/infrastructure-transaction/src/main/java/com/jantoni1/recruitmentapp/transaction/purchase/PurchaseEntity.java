package com.jantoni1.recruitmentapp.transaction.purchase;

import com.jantoni1.recruitmentapp.transaction.customer.CustomerEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "purchase")
@Setter
@Getter
public class PurchaseEntity {

    @Id
    @Column(updatable = false)
    protected UUID id = new UUID(0,0);
    @ManyToOne
    private CustomerEntity customer;

    private BigDecimal amount;

    private LocalDateTime purchaseDate;

}
