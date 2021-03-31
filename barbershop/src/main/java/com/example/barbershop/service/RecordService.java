package com.example.barbershop.service;

import com.example.barbershop.dtos.TimeSlot;
import com.example.barbershop.entity.RecordEntity;
import com.example.barbershop.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;

    public List<RecordEntity> findAllRecords() {
        return recordRepository.findAllRecords();
    }

    public RecordEntity findRecordById(int id) {
        return recordRepository.findRecordById(id);
    }

    public List<TimeSlot> getTimeSlotsForInterval(Instant start, Instant end, Integer master, Integer procedure) {
        return recordRepository.getFreeTimeSlots(start, end, master, procedure);
    }

    public List<RecordEntity> findAllRecordsByMasterId(int masterId) {
        return recordRepository.findAllRecordsByMasterId(masterId);
    }

    public List<RecordEntity> findAllRecordsByClientId(int masterId) {
        return recordRepository.findAllRecordsByClientId(masterId);
    }

    public List<RecordEntity> findAllRecordsByProcedureId(int procedureId) {
        return recordRepository.findAllRecordsByProcedureId(procedureId);
    }

    public List<RecordEntity> findAllRecordsByStatusId(int statusId) {
        return recordRepository.findAllRecordsByStatusId(statusId);
    }

    public List<RecordEntity> findAllRecordsByStatusName(String status) {
        return recordRepository.findAllRecordsByStatusName(status);
    }

    public void addRecord(RecordEntity record) {
        recordRepository.save(record);
    }

    public void updateRecord(RecordEntity record) {
        RecordEntity updatedRecord = recordRepository.findRecordById(record.getRecordId());
        if (updatedRecord != null) {
            updatedRecord.setClientId(record.getClientId());
            updatedRecord.setMasterId(record.getMasterId());
            updatedRecord.setProcedureId(record.getProcedureId());
            updatedRecord.setRecordTime(record.getRecordTime());
            updatedRecord.setStatusId(record.getStatusId());
            updatedRecord.setProcedureStart(record.getProcedureStart());
            updatedRecord.setProcedureFinish(record.getProcedureFinish());

            recordRepository.save(updatedRecord);
        }
    }

//    public List<RecordRepository> findAllRecordsByForLastWeek(){    }


}
