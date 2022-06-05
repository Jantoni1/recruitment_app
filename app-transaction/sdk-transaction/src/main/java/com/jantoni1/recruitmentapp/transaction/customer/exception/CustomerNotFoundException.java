package com.jantoni1.recruitmentapp.transaction.customer.exception;

import java.util.function.Supplier;
import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException {

    public static Supplier<CustomerNotFoundException> ofId(UUID id) {
        return () -> new CustomerNotFoundException("Customer With id: " + id + " not found");
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
