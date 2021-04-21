package com.example.barbershop.repository;

import com.example.barbershop.dtos.RecordInfoDto;
import com.example.barbershop.dtos.TimeSlot;
import com.example.barbershop.entity.QRecordEntity;
import com.example.barbershop.entity.RecordEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.util.List;

public interface RecordRepository extends JpaRepository<RecordEntity, Integer>, RecordRepositoryCustom {

    @Query("select r from RecordEntity r")
    List<RecordEntity> findAllRecords();

    @Query("select r from RecordEntity r where r.recordId=:recordId")
    <T> T findRecordById(@Param("recordId") int recordId, Class<T> returnType);

    @Query("select r from RecordEntity r where r.masterId=:masterId")
    List<RecordEntity> findAllRecordsByMasterId(@Param("masterId") int masterId);

    @Query("select r from RecordEntity r where r.clientId=:clientId")
    <T> List<T> findAllRecordsByClientId(@Param("clientId") int clientId, Class<T> returnType);

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

    void removeByRecordId(Integer recordId);

}

interface RecordRepositoryCustom {
    RecordInfoDto getRecordInfo(Integer id);
    List<RecordInfoDto> getClientRecords(Integer clientId);
}

@RequiredArgsConstructor
class RecordRepositoryCustomImpl implements RecordRepositoryCustom {
    private final EntityManager entityManager;

    @Override
    public RecordInfoDto getRecordInfo(Integer id) {
        var record = QRecordEntity.recordEntity;
        var query = new JPAQuery<QRecordEntity>(entityManager)
                .from(record)
                .where(record.recordId.eq(id));

        return selectRecordInfo(query).fetchOne();
    }

    public List<RecordInfoDto> getClientRecords(Integer clientId){
        var record = QRecordEntity.recordEntity;
        var query = new JPAQuery<QRecordEntity>(entityManager)
                .from(record)
                .where(record.clientId.eq(clientId));

        return selectRecordInfo(query).fetch();
    }

    private static JPAQuery<RecordInfoDto> selectRecordInfo(JPAQuery<QRecordEntity> query) {
        var record = QRecordEntity.recordEntity;
        return query.select(Projections.constructor(RecordInfoDto.class,
                record.recordId, record.procedureStart, record.procedureFinish,
                Projections.constructor(RecordInfoDto.Master.class,
                        record.master.accountId, record.master.firstName, record.master.lastName, record.master.secondName),
                Projections.constructor(RecordInfoDto.Procedure.class,
                        record.procedure.procedureId, record.procedure.name)));
    }
}