package com.example.barbershop.repository;

import com.example.barbershop.entity.ProcedureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Integer> {

    <T> List<T> findBy(Class<T> returnType);

    <T> Optional<T> findByProcedureId(Integer procedureId, Class<T> returnType);
}
