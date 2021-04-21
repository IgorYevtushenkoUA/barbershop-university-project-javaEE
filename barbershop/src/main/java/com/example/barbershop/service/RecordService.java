package com.example.barbershop.service;

import com.example.barbershop.dtos.RecordInfoDto;
import com.example.barbershop.dtos.TimeSlot;
import com.example.barbershop.entity.MasterEntity;
import com.example.barbershop.entity.ProcedureEntity;
import com.example.barbershop.entity.RecordEntity;
import com.example.barbershop.repository.ProcedureRepository;
import com.example.barbershop.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final ProcedureRepository procedureRepository;

    public List<RecordEntity> findAllRecords() {
        return recordRepository.findAllRecords();
    }

    public RecordEntity findRecordById(int id) {
        return recordRepository.findRecordById(id, RecordEntity.class);
    }

    public RecordInfoDto findCustomerRecordById(int id, int customer){
        var record = recordRepository.getRecordInfo(id);
//        if (customer != record.getClientId())
//            throw new UnauthorizedException();
        return record;
    }

    public List<TimeSlot> getTimeSlotsForInterval(Instant start, Instant end, Integer master, Integer procedure) {
        return recordRepository.getFreeTimeSlots(start, end, master, procedure);
    }

    public List<RecordEntity> findAllRecordsByMasterId(int masterId) {
        return recordRepository.findAllRecordsByMasterId(masterId);
    }

    public List<RecordInfoDto> findAllRecordsByClientId(int clientId) {
        return recordRepository.getClientRecords(clientId);
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

    public void addRecord(Integer clientId, Integer masterId, Integer procedureId, Instant procedureStart) {
        RecordEntity record = new RecordEntity();
        record.setClientId(clientId);
        record.setMaster(MasterEntity.builder().accountId(masterId).build());
        record.setProcedure(ProcedureEntity.builder().procedureId(procedureId).build());
        record.setRecordTime(Instant.now());
        record.setStatusId(1);
        record.setProcedureStart(procedureStart);
        Integer procedureDuration = procedureRepository.findById(procedureId).get().getDuration();
        record.setProcedureFinish(procedureStart.plusSeconds(60L * procedureDuration));

        recordRepository.save(record);
    }

    public void updateRecord(RecordEntity record) {
        RecordEntity updatedRecord = recordRepository.findRecordById(record.getRecordId(), RecordEntity.class);
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
