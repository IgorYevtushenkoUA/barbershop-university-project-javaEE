package com.example.barbershop.repository;

import com.example.barbershop.dtos.TimeSlot;
import com.example.barbershop.entity.RecordEntity;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
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

    @Query(nativeQuery = true)
    List<TimeSlot> getFreeTimeSlots(Instant start, Instant end, Integer master, Integer procedure);

    void removeAllByProcedureId(Integer procedureId);

    void removeAllByMasterId(Integer procedureId);

    void removeAllByClientId(Integer clientId);

}