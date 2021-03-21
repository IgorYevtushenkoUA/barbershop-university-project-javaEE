package com.example.barbershop.repository;

import com.example.barbershop.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<AccountEntity, Integer> {

//    void printRoles(){
//
//    }


}
