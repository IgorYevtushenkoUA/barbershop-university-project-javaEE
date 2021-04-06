package com.example.barbershop.config;

import com.example.barbershop.entity.AccountEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomAccountDetails implements UserDetails {

    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static CustomAccountDetails fromAccountEntityToCustomAccountDetails(AccountEntity accountEntity){
        CustomAccountDetails c = new CustomAccountDetails();
        c.email=accountEntity.getEmail();
        c.password=accountEntity.getPassword();
        c.grantedAuthorities= Collections.singletonList(new SimpleGrantedAuthority(accountEntity.getAccountRole().getName()));

        return c;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
