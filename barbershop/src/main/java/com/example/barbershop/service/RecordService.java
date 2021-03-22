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

    public List<RecordRepository> findAllRecords() {
        return recordRepository.findAllRecords();
    }

    public RecordRepository findRecordById(int id) {
        return recordRepository.findRecordById(id);
    }

    public List<RecordRepository> findAllRecordsByMasterId(int masterId) {
        return recordRepository.findAllRecordsByMasterId(masterId);
    }

    public List<RecordRepository> findAllRecordsByClientId(int masterId) {
        return recordRepository.findAllRecordsByClientId(masterId);
    }

    public List<RecordRepository> findAllRecordsByProcedureId(int procedureId) {
        return recordRepository.findAllRecordsByProcedureId(procedureId);
    }

    public List<RecordRepository> findAllRecordsByStatusId(int statusId) {
        return recordRepository.findAllRecordsByStatusId(statusId);
    }

    public List<RecordRepository> findAllRecordsByStatusName(String status) {
        return recordRepository.findAllRecordsByStatusName(status);
    }

    public void addRecord(RecordEntity record) {
        recordRepository.save(record);
    }

//    public List<RecordRepository> findAllRecordsByForLastWeek(){    }


}
