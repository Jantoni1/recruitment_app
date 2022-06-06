package com.jantoni1.recruitmentapp.transaction.purchase.exception;

import com.jantoni1.recruitmentapp.transaction.shared.RuntimeAppException;

import java.util.function.Supplier;
import java.util.UUID;

public class PurchaseNotFoundException extends RuntimeAppException {

    public static Supplier<PurchaseNotFoundException> ofId(UUID id) {
        return () -> new PurchaseNotFoundException("Purchase with idW: " + id + " not found");
    }

    public PurchaseNotFoundException(String message) {
        super(message);
    }
}
