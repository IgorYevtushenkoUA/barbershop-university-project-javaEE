package com.example.barbershop.repository;

import com.example.barbershop.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    @Query("select a from AccountEntity a")
    List<AccountEntity> findAllAccounts();
    // <? extends AccountEntity>

    @Query("select a from AccountEntity a where a.email=:email")
    <T> T findByEmail(@Param("email") String email, Class<T> returnType);

    @Query("select a from AccountEntity a where a.email=:email and a.password=:password")
    AccountEntity findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("select a from AccountEntity a where a.accountId=:accountId")
    AccountEntity findAccountById(@Param("accountId") int accountId);

    /**
     * find all admins
     */
    @Query("select a from AccountEntity a where a.roleId in " +
            "(select r.roleId from RoleEntity r where r.name='admin')")
    List<AccountEntity> findAllAdmin();

    /**
     * find all clients
     */
    @Query("select a from AccountEntity a where a.roleId in " +
            "(select r.roleId from RoleEntity r where r.name='client')")
    List<AccountEntity> findAllClient();

    /**
     * find all masters
     */
    @Query("select a from AccountEntity a where a.roleId in " +
            "(select r.roleId from RoleEntity r where r.name='master')")
    List<AccountEntity> findAllMaster();

    @Query("select a from AccountEntity a where a.firstName LIKE :firstName")
    List<AccountEntity> findAccountByFirstName(@Param("firstName") String firstName);

    @Query("select a from AccountEntity a where a.secondName LIKE :secondName")
    List<AccountEntity> findAccountBySecondName(@Param("secondName") String secondName);

    @Query("select a from AccountEntity a where a.lastName LIKE :lastName")
    List<AccountEntity> findAccountByLastName(@Param("lastName") String lastName);

    @Query("select a from AccountEntity a where a.phoneNumber=:phoneNumber and a.password=:password")
    AccountEntity findAccountByPhoneNumberAndPassword(@Param("phoneNumber") String phoneNumber,
                                                      @Param("password") String password);

    @Query("select a from AccountEntity a where a.email=:email and a.password=:password")
    AccountEntity findAccountByEmailAndPassword(@Param("email") String email,
                                                @Param("password") String password);

    @Query("select a from AccountEntity a where a.roleId in (select r.roleId from RoleEntity r where r.name=:name)")
    List<AccountEntity> findAccountByRole(@Param("name") String name);

}
