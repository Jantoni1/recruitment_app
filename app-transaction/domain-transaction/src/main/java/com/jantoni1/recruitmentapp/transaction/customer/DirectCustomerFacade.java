package com.jantoni1.recruitmentapp.transaction.customer;

import com.jantoni1.recruitmentapp.transaction.customer.dto.Customer;
import com.jantoni1.recruitmentapp.transaction.customer.dto.CustomerPurchasesRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
class DirectCustomerFacade implements CustomerFacade {

    private final CustomerService service;

    @Override
    public Optional<Customer> findById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Customer getOne(UUID id) {
        return service.getOne(id);
    }


    @Override
    public List<Customer> findAll(CustomerPurchasesRequest query) {
        return service.findAll(query);
    }

}
