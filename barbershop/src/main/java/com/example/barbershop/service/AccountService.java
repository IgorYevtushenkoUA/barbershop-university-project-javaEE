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

    public List<? extends AccountEntity> findAllAdmin() {
        return accountRepository.findAllAdmin();
    }

    public List<AccountEntity> findAllClient() {
        return accountRepository.findAllClient();
    }

    public List<AccountEntity> findAllMaster() {
        return accountRepository.findAllMaster();
    }

    public AccountEntity findAccountById(int accountId) {
        return accountRepository.findAccountById(accountId);
    }

    public List<AccountEntity> findAllAccounts() {
        return accountRepository.findAll();
    }









    /* add account */
    public <T extends AccountEntity> T addAccount(T account) {
        System.out.println(account);
        return accountRepository.save(account);
    }


















    /* update by id */
    public void updateAccountById(AccountEntity account) {
        AccountEntity updatedAccount = accountRepository.findAccountById(account.getAccountId());
        if (updatedAccount != null) {
            updatedAccount.setEmail(account.getEmail());
            updatedAccount.setPassword(account.getPassword());
            updatedAccount.setRoleId(account.getRoleId());
            updatedAccount.setPhoneNumber(account.getPhoneNumber());
            updatedAccount.setFirstName(account.getFirstName());
            updatedAccount.setSecondName(account.getSecondName());
            updatedAccount.setLastName(account.getLastName());
            updatedAccount.setAge(account.getAge());
            updatedAccount.setGender(account.getGender());
//        updatedAccount.setRole(account.getRole()); // хз  чи треба
            accountRepository.save(updatedAccount);
        }
    }


    /* delete account by id */
    public void deleteAccountById(int accountId) {
        if (accountRepository.findAccountById(accountId) != null)
            accountRepository.deleteById(accountId);
    }

    /* find by firstName + secondName + LastName */
    public List<AccountEntity> findAccountByFirstName(String firstName) {
        return accountRepository.findAccountByFirstName(firstName);
    }

    public List<AccountEntity> findAccountBySecondName(String secondName) {
        return accountRepository.findAccountBySecondName(secondName);
    }

    public List<AccountEntity> findAccountByLastName(String lastName) {
        return accountRepository.findAccountByLastName(lastName);
    }

    /* Get account by email and password */
    public AccountEntity findAccountByPhoneNumberAndPassword(String phoneNumber, String password) {
        return accountRepository.findAccountByPhoneNumberAndPassword(phoneNumber, password);
    }

    public AccountEntity findAccountByEmailAndPassword(String phoneNumber, String password) {
        return accountRepository.findAccountByEmailAndPassword(phoneNumber, password);
    }

    /*  */
    /*  */
    /*  */

}
