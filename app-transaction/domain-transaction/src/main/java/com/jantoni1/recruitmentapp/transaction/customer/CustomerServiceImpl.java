package com.jantoni1.recruitmentapp.transaction.customer;

import com.jantoni1.recruitmentapp.transaction.customer.dto.Customer;
import com.jantoni1.recruitmentapp.transaction.customer.dto.CustomerPurchasesRequest;
import com.jantoni1.recruitmentapp.transaction.customer.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public Optional<Customer> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Customer getOne(UUID id) {
        return findById(id).orElseThrow(CustomerNotFoundException.ofId(id));
    }

    @Override
    public List<Customer> findAll(CustomerPurchasesRequest query) {
        return repository.findAllWithPurchases(query);
    }

}
