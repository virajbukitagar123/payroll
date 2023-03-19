package org.example.payroll.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Couldn't find order: " + id);
    }
}
