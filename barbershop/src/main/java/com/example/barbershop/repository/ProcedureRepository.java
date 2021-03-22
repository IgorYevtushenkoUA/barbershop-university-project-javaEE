package com.example.barbershop.repository;

import com.example.barbershop.entity.ProcedureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Integer> {

    @Query("select p from ProcedureEntity p where p.procedureId=:id")
    ProcedureEntity findAllById(@Param("id") int id);
}
