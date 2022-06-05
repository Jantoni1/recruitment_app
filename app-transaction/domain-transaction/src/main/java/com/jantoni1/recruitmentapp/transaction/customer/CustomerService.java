package com.jantoni1.recruitmentapp.transaction.customer;

import com.jantoni1.recruitmentapp.transaction.customer.dto.Customer;
import java.util.Optional;
import java.util.UUID;

import java.util.List;
import com.jantoni1.recruitmentapp.transaction.customer.dto.CustomerPurchasesRequest;

interface CustomerService {

    Optional<Customer> findById(UUID id);

    Customer getOne(UUID id);

    List<Customer> findAll(CustomerPurchasesRequest query);

}
