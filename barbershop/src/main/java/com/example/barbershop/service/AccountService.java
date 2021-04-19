package com.example.barbershop.service;

import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.entity.RoleEntity;
import com.example.barbershop.repository.AccountRepository;
import com.example.barbershop.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
//@RequiredArgsConstructor
public class AccountService {

//    private final AccountRepository accountRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AccountEntity saveAccount(AccountEntity accountEntity, String roleName){
        RoleEntity accountRole = roleRepository.findByName(roleName);
        accountEntity.setRoleId(accountRole.getRoleId()); //  return null
        accountEntity.setPassword(passwordEncoder.encode(accountEntity.getPassword()));

        return accountRepository.save(accountEntity);
    }

    public AccountEntity findByEmail(String email){
        return accountRepository.findByEmail(email);
    }

    public AccountEntity findByEmailAndPassword(String email, String password){
        AccountEntity accountEntity = findByEmail(email);
        if (accountEntity!=null){
            if (password.equals(accountEntity.getPassword())){
                return accountEntity;
            }
        }
        return null;
    }

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
            accountRepository.save(updatedAccount);
        }
    }

    public List<AccountEntity> findAccountByRole(String role){
        return accountRepository.findAccountByRole(role);
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

}
