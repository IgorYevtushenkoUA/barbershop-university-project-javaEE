package com.example.barbershop.service;

import com.example.barbershop.entity.MasterEntity;
import com.example.barbershop.entity.ProcedureEntity;
import com.example.barbershop.repository.ProcedureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProcedureService {

    private final ProcedureRepository procedureRepository;


    public ProcedureEntity findProcedureById(Integer id) {
        return procedureRepository.findAllById(id);
    }

    public List<MasterEntity> findAllProcedureMasters(int procedureId) {
        ProcedureEntity procedure = procedureRepository.findAllById(procedureId);
        return procedure != null
                ? procedure.getMasters()
                : null;
    }

    public List<MasterEntity> findAllProcedureMasters(ProcedureEntity procedure) {
        return procedure.getMasters();
    }

}
