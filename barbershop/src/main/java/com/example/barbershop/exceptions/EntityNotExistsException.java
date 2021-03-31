package com.example.barbershop.exceptions;

public class EntityNotExistsException extends RuntimeException {
    public EntityNotExistsException(String id) {
        super("Could not find entity with id: " + id);
    }
}
