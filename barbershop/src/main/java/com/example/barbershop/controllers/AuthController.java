package com.example.barbershop.controllers;

import com.example.barbershop.config.jwt.JwtProvider;
import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.entity.ClientEntity;
import com.example.barbershop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerAccount(@RequestBody @Valid RegistrationRequest registrationRequest){
        AccountEntity accountEntity = new ClientEntity(); // todo
        accountEntity.setPassword(registrationRequest.getPassword());
        accountEntity.setEmail(registrationRequest.getEmail());
        accountService.saveAccount(accountEntity,"CLIENT");
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        AccountEntity accountEntity = accountService.findByEmailAndPassword(request.getEmail(), request.getPassword());
        String token = jwtProvider.generateToken(accountEntity.getEmail());
        return new AuthResponse(token);
    }


}

