package com.example.barbershop.dtos.auth;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RegistrationRequest {
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    // todo when will real data -> розкоментувати
//    @NotEmpty
    private int roleId;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String secondName;
    @NotEmpty
    private String lastName;
    @NotNull
    private Integer age;
    @NotNull
    private Character gender;

}