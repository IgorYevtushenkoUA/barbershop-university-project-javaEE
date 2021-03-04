package com.example.barbershop.service;


import com.example.barbershop.entity.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.jpa.provider.HibernateUtils;
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
    public void createAccount(
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

        entityManager.persist(account);
    }

    /** get account by ID */
    @Transactional
    public AccountEntity getAccountById(int accountId){
        return entityManager.find(AccountEntity.class, accountId);
    }

    /** get All account */
    public List<AccountEntity> getAllAccounts(){
        return entityManager.createQuery("SELECT a FROM AccountEntity a", AccountEntity.class)
                .getResultList();
    }

    /** update account by ID*/
//    @Transactional
//    public void updateAccountById(int accountId){
//        return entityManager.createQuery("UPDATE account FROM AccountEntity a SET age=10 where a.id=1", AccountEntity.class);
//    }


    // edit account
    // delete account by ID



    // xz треба по всім параметрам робити пошук
    // get account by name
    // get account by rating
    // get account

}
