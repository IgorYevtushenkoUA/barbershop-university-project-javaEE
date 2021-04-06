package com.example.barbershop.controllers.auth;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegistrationRequest {
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    // todo when will real data -> розкоментувати
//    @NotEmpty
//    private int roleId;
//    @NotEmpty
//    private String phoneNumber;
//    @NotEmpty
//    private String firstName;
//    @NotEmpty
//    private String secondName;
//    @NotEmpty
//    private String lastName;
//    @NotEmpty
//    private int age;
//    @NotEmpty
//    private char gender;



}