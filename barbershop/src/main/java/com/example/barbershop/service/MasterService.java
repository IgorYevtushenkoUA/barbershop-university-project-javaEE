package com.example.barbershop.service;

import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.entity.MasterEntity;
import com.example.barbershop.entity.ProcedureEntity;
import com.example.barbershop.repository.MasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MasterService {

    private final MasterRepository masterRepository;

    @Autowired
    AccountService accountService;


    public List<? extends AccountEntity> findAllMaster() {
        return masterRepository.findAllMaster();
    }

    public MasterEntity findMasterById(int masterId) {
        return masterRepository.findMasterById(masterId);
    }

    // todo check
    public void deleteMasterById(int id) {
        if (masterRepository.findMasterById(id) != null) {
            masterRepository.deleteById(id);
            accountService.deleteAccountById(id);
        }
    }

    /* add procedure */
    public void addToMasterProcedure(MasterEntity master, ProcedureEntity procedure) {
        if (master.getProcedures()
                .stream()
                .filter(p -> p.getProcedureId() == procedure.getProcedureId())
                .count() == 0) {
            master.getProcedures().add(procedure);
            masterRepository.save(master);
        }
    }

    /* delete procedure */
    public void deleteInMasterProcedure(MasterEntity master, ProcedureEntity procedure) {
        if (master.getProcedures()
                .stream()
                .filter(p -> p.getProcedureId() == procedure.getProcedureId())
                .count() > 0) {
            master.setProcedures(master.getProcedures()
                    .stream()
                    .filter(p -> p.getProcedureId() != procedure.getProcedureId())
                    .collect(Collectors.toList()));
            masterRepository.save(master);
        }
    }

    public List<ProcedureEntity> findAllMastersProcedure(MasterEntity master) {
        return master.getProcedures();
    }

    public List<ProcedureEntity> findAllMastersProcedure(int masterId) {
        MasterEntity master = masterRepository.findMasterById(masterId);
        return master != null
                ? master.getProcedures()
                : null;
    }

    public void updateMaster(MasterEntity master) {
        MasterEntity updatedMaster = masterRepository.findMasterById(master.getAccountId());
        if (updatedMaster != null) {
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

            masterRepository.save(updatedMaster);
        }
    }

}
