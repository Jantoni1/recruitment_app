package com.jantoni1.recruitmentapp.transaction.customer;

import com.jantoni1.recruitmentapp.transaction.customer.dto.Customer;
import com.jantoni1.recruitmentapp.transaction.customer.dto.CustomerPurchasesRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

interface CustomerRepository {

    Optional<Customer> findById(UUID id);

    List<Customer> findAllWithPurchases(CustomerPurchasesRequest query);
}
