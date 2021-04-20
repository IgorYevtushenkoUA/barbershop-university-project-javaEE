package com.example.barbershop.config;

import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomAccountDetailService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public CustomAccountDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountService.findByEmail(email, AccountEntity.class);
        return CustomAccountDetails.fromAccountEntityToCustomAccountDetails(accountEntity);
    }
}
