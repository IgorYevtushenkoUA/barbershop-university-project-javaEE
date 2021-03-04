package com.example.barbershop.service;

import com.example.barbershop.entity.RecordEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final EntityManager entityManager;

    /**
     * get all record
     */
    @Transactional
    public List<RecordEntity> getAllRecord() {
        System.out.println("getAllRecord");
        return entityManager.createQuery("SELECT r FROM RecordEntity r", RecordEntity.class)
                .getResultList();
    }

    /**
     * get record by Id
     */
    @Transactional
    public RecordEntity getRecordById(int recordId) {
        System.out.println("getRecordById");
        return entityManager.find(RecordEntity.class, recordId);
    }

    /**
     * todo test method
     * edit record by Id
     */
    @Transactional
    public void editRecordById(
            int recordId,
            int clientId,
            int masterId,
            int procedureId,
            Date recordTime,
            int statusId,
            Date procedureTimeRecord
    ) {
        RecordEntity updatedRecord = new RecordEntity(
                recordId,
                clientId,
                masterId,
                procedureId,
                recordTime,
                statusId,
                procedureTimeRecord
        );
        entityManager.merge(updatedRecord);
        System.out.println("getRecordById");
    }

    /**
     * todo test method
     * add new record
     */
    @Transactional
    public void createRecord(
            int clientId,
            int masterId,
            int procedureId,
            Date recordTime,
            int statusId,
            Date procedureTimeRecord
    ) {
        RecordEntity updatedRecord = new RecordEntity();
        updatedRecord.setClientId(clientId);
        updatedRecord.setMasterId(masterId);
        updatedRecord.setProcedureId(procedureId);
        updatedRecord.setRecordTime(recordTime);
        updatedRecord.setStatusId(statusId);
        updatedRecord.setProcedureTimeRecord(procedureTimeRecord);

        entityManager.merge(updatedRecord);
        System.out.println("getRecordById");
    }

    /** get all record by master*/
}
