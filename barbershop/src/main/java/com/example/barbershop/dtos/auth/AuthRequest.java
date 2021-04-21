package com.example.barbershop.dtos.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
