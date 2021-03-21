package com.example.barbershop.service;

import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.repository.AccountRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<AccountEntity> findAllAdminByRole(){
        return accountRepository.findAllAdminByRole();
    }

    public List<AccountEntity> findAllClientByRole(){
        return accountRepository.findAllClientByRole();
    }

    public List<AccountEntity> findAllMasterByRole(){
        return accountRepository.findAllMasterByRole();
    }

    public AccountEntity findAccountById(int accountId){
        return accountRepository
                .findById(accountId)
                .stream()
                .findFirst()
                .orElse(null);
    }

    public List<AccountEntity> findAllAccounts(){
        return accountRepository.findAll();
    }

    /* update by id */
    /* delete account by id */
    /* find by firstName + secondName + LastName */
    /* Get account by email and password */
    /*  */
    /*  */
    /*  */



}
