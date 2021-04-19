package com.example.barbershop.service;

import com.example.barbershop.dtos.MasterDto;
import com.example.barbershop.entity.AccountEntity;
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
public class MasterService {

    private final MasterRepository masterRepository;
    private final AccountService accountService;
    private final ProcedureRepository procedureRepository;


    public List<? extends AccountEntity> findAllMaster() {
        return masterRepository.findAllMaster();
    }

    public List<MasterDto> findAllMaster(Integer procedure) {
        return masterRepository.findByProceduresProcedureId(procedure, MasterDto.class);
    }

    public List<? extends MasterDto> findAllMaster(Integer procedure, Optional<Integer> levelId, Optional<String> sortBy) {
        return masterRepository.findMasters(procedure, levelId, sortBy);
    }

    public Optional<MasterDto> findMasterById(int masterId) {
        return masterRepository.findByAccountId(masterId, MasterDto.class);
    }

    // todo check
    public void deleteMasterById(int id) {
        if (masterRepository.findById(id).isPresent()) {
            deleteInMasterAllProcedure(id);
            masterRepository.deleteById(id);
            accountService.deleteAccountById(id);
        }
    }

    /* add procedure */
    public void addToMasterProcedure(MasterEntity master, ProcedureEntity procedure) {
        if (master.getProcedures()
                .stream().noneMatch(p -> p.getProcedureId().equals(procedure.getProcedureId()))) {
            master.getProcedures().add(procedure);
            masterRepository.save(master);
        }
    }

    /* delete procedure */
    public void deleteInMasterProcedures(MasterDto m, ProcedureEntity procedure) {
        MasterEntity master = masterRepository.findById(m.getAccountId()).orElse(null);
        if (master.getProcedures()
                .stream().anyMatch(p -> p.getProcedureId().equals(procedure.getProcedureId()))) {
            master.setProcedures(master.getProcedures()
                    .stream()
                    .filter(p -> !p.getProcedureId().equals(procedure.getProcedureId()))
                    .collect(Collectors.toList()));
            masterRepository.save(master);
        }
    }

    public void deleteInMasterProcedures(int masterId, int procedureId) {
        MasterDto master = findMasterById(masterId).orElse(null);
        ProcedureEntity procedure = procedureRepository.findById(procedureId).orElse(null);
        deleteInMasterProcedures(master, procedure);
    }

    public void deleteInMasterAllProcedure(int masterId) {
        MasterEntity master = masterRepository.findById(masterId).orElse(null);
        master.setProcedures(new ArrayList<>());
        masterRepository.save(master);
    }

    public List<ProcedureEntity> findAllMastersProcedure(MasterEntity master) {
        return master.getProcedures();
    }

    public List<ProcedureEntity> findAllMastersProcedure(int masterId) {
        var master = masterRepository.findById(masterId);
        return master.map(MasterEntity::getProcedures).orElse(null);
    }

    public void updateMasterRating(Integer masterId, Double rating){
        var dbMaster = masterRepository.findById(masterId).get();
        dbMaster.setRating(rating);
        masterRepository.save(dbMaster);
    }

    public void updateMaster(MasterEntity master) {
        var dbMaster = masterRepository.findById(master.getAccountId());
        if (dbMaster.isPresent()) {
//            var updatedMaster = dbMaster.get();
            MasterEntity updatedMaster = new MasterEntity();
            updatedMaster.setAccountId(master.getAccountId());
            updatedMaster.setEmail(master.getEmail());
            updatedMaster.setPassword(master.getPassword());
            updatedMaster.setRoleId(master.getRoleId());
            updatedMaster.setPhoneNumber(master.getPhoneNumber());
            updatedMaster.setFirstName(master.getFirstName());
            updatedMaster.setSecondName(master.getSecondName());
            updatedMaster.setLastName(master.getLastName());
            updatedMaster.setAge(master.getAge());
            updatedMaster.setGender(master.getGender());
            updatedMaster.setWorkExperience(master.getWorkExperience());
            updatedMaster.setRating(master.getRating());
            updatedMaster.setLevelId(master.getLevelId());
            updatedMaster.setLevel(master.getLevel());
            updatedMaster.setPhoto(master.getPhoto());
            masterRepository.save(updatedMaster);
        }

    }
}
