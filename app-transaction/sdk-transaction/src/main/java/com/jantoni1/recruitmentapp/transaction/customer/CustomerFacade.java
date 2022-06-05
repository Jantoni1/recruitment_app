package com.jantoni1.recruitmentapp.transaction.customer;

import com.jantoni1.recruitmentapp.transaction.customer.dto.Customer;
import com.jantoni1.recruitmentapp.transaction.customer.dto.CustomerPurchasesRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerFacade {

    Optional<Customer> findById(UUID id);

    Customer getOne(UUID id);

    List<Customer> findAll(CustomerPurchasesRequest query);

}
