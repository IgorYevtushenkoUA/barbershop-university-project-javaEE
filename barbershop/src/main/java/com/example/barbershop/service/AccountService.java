package com.example.barbershop.service;


import com.example.barbershop.entity.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final EntityManager entityManager;

    // create new Account
    // todo problem with PK
    @Transactional
    public AccountEntity createAccount(
            String email,
            String password,
            int roleId,
            String phoneNumber,
            String firstName,
            String secondName,
            String lastName,
            int age,
            char gender
    ) {
        AccountEntity account = new AccountEntity();
        account.setEmail(email);
        account.setPassword(password);
        account.setRoleId(roleId);
        account.setPhoneNumber(phoneNumber);
        account.setFirstName(firstName);
        account.setSecondName(secondName);
        account.setLastName(lastName);
        account.setAge(age);
        account.setGender(gender);

        return entityManager.merge(account); // persist
    }

    /**
     * get account by ID
     */
    @Transactional
    public AccountEntity getAccountById(int accountId) {
        System.out.println("getAccountById");
        return entityManager.find(AccountEntity.class, accountId);
    }

    /**
     * get All account
     */
    public List<AccountEntity> getAllAccounts() {
        System.out.println("getAllAccounts");
        return entityManager.createQuery("SELECT a FROM AccountEntity a", AccountEntity.class)
                .getResultList();
    }

    /**
     * update account by ID
     */
    @Transactional
    public void updateAccountById(
            Integer accountId,
            String email,
            String password,
            Integer roleId,
            String phoneNumber,
            String firstName,
            String secondName,
            String lastName,
            int age,
            char gender) {
        AccountEntity updatedAccount = new AccountEntity(
                accountId,
                email,
                password,
                roleId,
                phoneNumber,
                firstName,
                secondName,
                lastName,
                age,
                gender);
        entityManager.merge(updatedAccount);
    }

    /**
     * delete account by ID
     */
    @Transactional
    public void deleteAccountById(int accountId) {
        entityManager.createQuery("delete from AccountEntity a where a.accountId = :accountId")
                .setParameter("accountId", accountId)
                .executeUpdate();
    }

}
