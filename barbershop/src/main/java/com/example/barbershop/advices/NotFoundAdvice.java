package com.example.barbershop.advices;

import com.example.barbershop.exceptions.EntityNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class NotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(EntityNotExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(EntityNotExistsException ex) {
        return ex.getMessage();
    }
}