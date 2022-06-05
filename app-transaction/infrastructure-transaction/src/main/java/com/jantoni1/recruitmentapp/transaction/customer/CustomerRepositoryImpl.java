package com.jantoni1.recruitmentapp.transaction.customer;

import com.jantoni1.recruitmentapp.transaction.customer.dto.Customer;
import com.jantoni1.recruitmentapp.transaction.customer.dto.CustomerPurchasesRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Transactional
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerEntityMapper mapper;

    private final CustomerEntityRepository repository;

    @Cacheable(value = "customer-getOne")
    @Override
    public Optional<Customer> findById(UUID id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Cacheable(value = "customer-purchases-three-months")
    @Override
    public List<Customer> findAllWithPurchases(CustomerPurchasesRequest query) {
        return repository.findAll(new CustomerEntitySpec(query)).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

}
