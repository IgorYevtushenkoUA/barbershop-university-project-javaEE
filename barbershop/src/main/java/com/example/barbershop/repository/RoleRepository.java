package com.example.barbershop.repository;

import com.example.barbershop.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    @Query("select r from RoleEntity r where r.name=:name")
    RoleEntity findByName(@Param("name") String name);


//    Optional<RoleEntity> findByName(String name);

}
