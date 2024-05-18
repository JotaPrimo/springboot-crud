package com.jotasantos.springbootcrud.springbootcrud.exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}