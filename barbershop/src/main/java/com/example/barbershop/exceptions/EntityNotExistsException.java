package com.example.barbershop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotExistsException extends RuntimeException {
    public EntityNotExistsException(String id) {
        super("Could not find entity with id: " + id);
    }
}
