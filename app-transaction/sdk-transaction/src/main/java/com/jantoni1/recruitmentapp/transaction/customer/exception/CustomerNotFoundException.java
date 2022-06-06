package com.jantoni1.recruitmentapp.transaction.customer.exception;

import com.jantoni1.recruitmentapp.transaction.shared.RuntimeAppException;

import java.util.function.Supplier;
import java.util.UUID;

public class CustomerNotFoundException extends RuntimeAppException {

    public static Supplier<CustomerNotFoundException> ofId(UUID id) {
        return () -> new CustomerNotFoundException("Customer With id: " + id + " not found");
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
