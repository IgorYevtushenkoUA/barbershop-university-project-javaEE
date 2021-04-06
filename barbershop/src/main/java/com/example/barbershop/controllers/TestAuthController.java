package com.example.barbershop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAuthController {

    @GetMapping("/user")
    public String getUser(){
        return "User hello";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "admin Hello";
    }

}
