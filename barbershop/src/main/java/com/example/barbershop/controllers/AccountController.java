package com.example.barbershop.controllers;

import com.example.barbershop.dtos.AccountDto;
import com.example.barbershop.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @RequestMapping("/account")
    public AccountDto getAccountInfo(){
        var user = SecurityContextHolder.getContext().getAuthentication().getName();
        var account = accountService.findByEmail(user, AccountDto.class);
        return account;
    }
}
