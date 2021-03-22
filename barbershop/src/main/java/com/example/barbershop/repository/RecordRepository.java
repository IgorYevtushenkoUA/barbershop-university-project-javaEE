package com.example.barbershop.repository;

import com.example.barbershop.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecordRepository extends JpaRepository<RecordEntity, Integer> {

    @Query("select r from RecordEntity r")
    List<RecordEntity> findAllRecords();

    @Query("select r from RecordEntity r where r.recordId=:recordId")
    RecordEntity findRecordById(@Param("recordId") int recordId);

    @Query("select r from RecordEntity r where r.masterId=:masterId")
    List<RecordEntity> findAllRecordsByMasterId(@Param("masterId") int masterId);

    @Query("select r from RecordEntity r where r.clientId=:clientId")
    List<RecordEntity> findAllRecordsByClientId(@Param("clientId") int clientId);

    @Query("select r from RecordEntity r where r.procedureId=:procedureId")
    List<RecordEntity> findAllRecordsByProcedureId(@Param("procedureId") int procedureId);

    @Query("select r from RecordEntity r where r.statusId=:statusId")
    List<RecordEntity> findAllRecordsByStatusId(@Param("statusId") int statusId);

    @Query("select r from RecordEntity r where r.statusId in (select s.statusId from StatusEntity s where s.name=:name)")
    List<RecordEntity> findAllRecordsByStatusName(@Param("name") String name);


}
