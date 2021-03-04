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
    public void updateAccountById(AccountEntity account) {
        entityManager.merge(account);
    }

    /**
     * delete account by ID
     */
    @Transactional
    public void deleteAccountById(int accountId) {
        entityManager.createQuery("delete from AccountEntity a where a.accountId = :accountId", AccountEntity.class)
                .setParameter("accountId", accountId)
                .executeUpdate();
    }

    /**
     * todo check method
     * find by firstName + secondName + LastName
     */
    @Transactional
    public List<AccountEntity> findAccountByName(String name) {
        System.out.println("findAccountByName");
        return entityManager.createQuery("SELECT a FROM AccountEntity a " +
                "WHERE a.firstName LIKE : firstName " +
                "OR  a.secondName LIKE : secondName " +
                "OR  a.lastName LIKE : lastName", AccountEntity.class)
                .setParameter("firstName", '%' + name + '%')
                .setParameter("secondName", '%' + name + '%')
                .setParameter("lastName", '%' + name + '%')
                .getResultList();
    }

    /**
     * todo check method
     * find by role
     */
    @Transactional
    public List<AccountEntity> findAccountByRoleId(int roleId) {
        System.out.println("findAccountByRoleId");
        return entityManager.createQuery("SELECT a FROM AccountEntity a " +
                "WHERE a.roleId = : roleId", AccountEntity.class)
                .setParameter("roleId", roleId)
                .getResultList();
    }

    /**
     * get list of account with email + password
     */
    @Transactional
    public List getAccountsByEmailAndPassword(String email, String password) {
        return entityManager.createQuery("SELECT a FROM AccountEntity a " +
                "WHERE a.email = :email " +
                "AND a.password = : password")
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList();
    }

    /** get account by email and password */
    @Transactional
    public AccountEntity getAccountByEmailAndPassword(String email, String password) {
        List accounts = getAccountsByEmailAndPassword(email, password);
        return accounts.isEmpty()
                ? null
                : (AccountEntity) accounts.get(0);
    }
}
