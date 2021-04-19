package com.example.barbershop.repository;

import com.example.barbershop.dtos.MasterDto;
import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.entity.MasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MasterRepository extends JpaRepository<MasterEntity, Integer> {

    @Query("select m from MasterEntity m")
    List<MasterDto> findAllMaster();

    <T> Optional<T> findByAccountId(Integer accountId, Class<T> returnType);

    <T> List<T> findByProceduresProcedureId(Integer procedureId, Class<T> returnType);

    <T> List<T> findByLevel_Name(String name, Class<T> returnType);

    <T> List<T> findDistinctAllByProceduresProcedureIdAndLevelLevelIdInOrderByRatingAsc(@Param("procedureId") Integer procedureId, @Param("levelId") List<Integer> levelId, Class<T> returnType);

    <T> List<T> findDistinctAllByProceduresProcedureIdAndLevelLevelIdInOrderByRatingDesc(@Param("procedureId") Integer procedureId, @Param("levelId") List<Integer> levelId, Class<T> returnType);
}
