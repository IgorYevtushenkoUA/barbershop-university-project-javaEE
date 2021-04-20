package com.example.barbershop.service;

import com.example.barbershop.dtos.ProcedureDto;
import com.example.barbershop.entity.MasterEntity;
import com.example.barbershop.entity.ProcedureEntity;
import com.example.barbershop.repository.MasterRepository;
import com.example.barbershop.repository.ProcedureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProcedureService {

    private final ProcedureRepository procedureRepository;
    private final MasterService masterService;
    private final MasterRepository masterRepository;
    private final RecordService recordService;

    public List<ProcedureDto> getAllProcedures() {
        return procedureRepository.findBy(ProcedureDto.class);
    }

    public Optional<ProcedureDto> findProcedureById(Integer id) {
        return procedureRepository.findByProcedureId(id, ProcedureDto.class);
    }

    public List<MasterEntity> findAllProcedureMasters(int procedureId) {
        var procedure = procedureRepository.findById(procedureId);
        return procedure.map(ProcedureEntity::getMasters).orElse(null);
    }

    public List<MasterEntity> findAllProcedureMasters(ProcedureEntity procedure) {
        return procedure.getMasters();
    }

//    public List<? extends ProcedureDto> findAllProcedures(Optional<Integer> priceFrom, Optional<Integer> priceTo, Optional<String> sortBy) {
//        return procedureRepository.findProcedures(priceFrom, priceTo, sortBy);
//    }

    public List<? extends ProcedureDto> findAllProcedures(Optional<Integer> priceFrom, Optional<Integer> priceTo, Optional<String> sortBy) {
        return procedureRepository.findProcedures(priceFrom, priceTo, sortBy);
    }

    public void updateMasterRating(Integer masterId, Double rating){
        var dbMaster = masterRepository.findById(masterId).get();
        dbMaster.setRating(rating);
        masterRepository.save(dbMaster);
    }

    public void deleteProcedureById(int procedureId) {
        if (procedureRepository.findById(procedureId).isPresent()) {
            recordService.removeAllByProcedureId(procedureId);
            deleteInMasterProcedure(procedureId);
            deleteInProcedureMasters(procedureId);
            procedureRepository.deleteById(procedureId);
        }
    }

    public void deleteInProcedureMasters(int procedureId) {
        ProcedureEntity procedure = procedureRepository.findById(procedureId).orElse(null);
        procedure.setMasters(new ArrayList<>());
        procedureRepository.save(procedure);
    }

    public void deleteInMasterProcedure(int procedureId) {
        List<MasterEntity> masters = (List<MasterEntity>) masterService.findAllMaster();
        for (int i = 0; i < masters.size(); i++) {
            MasterEntity master = masters.get(i);
            master.setProcedures(master.getProcedures()
                    .stream().filter(p -> !p.getProcedureId().equals(procedureId))
                    .collect(Collectors.toList()));
            masterRepository.save(master);
        }
    }

    public void updateProcedure(ProcedureEntity procedure) {
        var dbProcedure = procedureRepository.findById(procedure.getProcedureId());
        if (dbProcedure.isPresent()) {
            ProcedureEntity upProcedure = new ProcedureEntity();
            upProcedure.setProcedureId(procedure.getProcedureId());
            upProcedure.setMasters(procedure.getMasters());
            upProcedure.setDuration(procedure.getDuration());
            upProcedure.setPrice(procedure.getPrice());
            upProcedure.setName(procedure.getName());
            procedureRepository.save(upProcedure);
        }
    }

    public void addProcedure(ProcedureEntity procedure) {
        procedureRepository.save(procedure);
    }

}

