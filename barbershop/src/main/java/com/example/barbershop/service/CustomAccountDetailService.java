package com.example.barbershop.service;

import com.example.barbershop.config.CustomAccountDetails;
import com.example.barbershop.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomAccountDetailService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public CustomAccountDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountService.findByEmail(email);
        return CustomAccountDetails.fromAccountEntityToCustomAccountDetails(accountEntity);
    }
}
