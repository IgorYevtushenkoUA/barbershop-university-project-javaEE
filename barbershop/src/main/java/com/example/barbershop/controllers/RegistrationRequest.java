package com.example.barbershop.controllers;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

//@Getter
//@Setter
@Data
public class RegistrationRequest {
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

}