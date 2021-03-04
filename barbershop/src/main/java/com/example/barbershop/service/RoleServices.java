package com.example.barbershop.service;

import com.example.barbershop.entity.RoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServices {

    private final EntityManager entityManager;

    /**
     * get all roles
     */
    @Transactional
    public List<RoleEntity> getAllRoles(){
        System.out.println("getAllRoles");
        return entityManager.createQuery("SELECT r FROM RoleEntity r", RoleEntity.class)
                .getResultList();
    }

    /**
     * get role by ID
     */
    @Transactional
    public RoleEntity getRoleById(int roleId){
        return entityManager.find(RoleEntity.class, roleId);
    }

}
