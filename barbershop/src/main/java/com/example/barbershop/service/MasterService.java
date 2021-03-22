package com.example.barbershop.service;

import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.entity.LevelEntity;
import com.example.barbershop.entity.MasterEntity;
import com.example.barbershop.entity.ProcedureEntity;
import com.example.barbershop.repository.AccountRepository;
import com.example.barbershop.repository.MasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MasterService {

    private final MasterRepository masterRepository;
    private final AccountRepository accountRepository;


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


    /* update procedure */

}
