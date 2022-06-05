package com.jantoni1.recruitmentapp.transaction.customer.dto;

import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Customer implements Serializable {

    private UUID id = UUID.randomUUID();

    private String firstName;

    private String lastName;

    private List<Purchase> purchases;

}
