package com.example.barbershop.repository;

import com.example.barbershop.entity.AccountEntity;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    /** find all admins */
    @Query("select a from AccountEntity a where a.roleId in " +
            "(select r.roleId from RoleEntity r where r.name='admin')")
    List<AccountEntity> findAllAdminByRole();

    /** find all clients */
    @Query("select a from AccountEntity a where a.roleId in " +
            "(select r.roleId from RoleEntity r where r.name='client')")
    List<AccountEntity> findAllClientByRole();

    /** find all masters */
    @Query("select a from AccountEntity a where a.roleId in " +
            "(select r.roleId from RoleEntity r where r.name='master')")
    List<AccountEntity> findAllMasterByRole();


    // add

    // delete

    // update



}
