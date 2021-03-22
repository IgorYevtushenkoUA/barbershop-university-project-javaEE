package com.example.barbershop.service;

import com.example.barbershop.entity.RecordEntity;
import com.example.barbershop.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            updatedRecord.setProcedureTimeRecord(record.getProcedureTimeRecord());

            recordRepository.save(updatedRecord);
        }
    }

//    public List<RecordRepository> findAllRecordsByForLastWeek(){    }


}
