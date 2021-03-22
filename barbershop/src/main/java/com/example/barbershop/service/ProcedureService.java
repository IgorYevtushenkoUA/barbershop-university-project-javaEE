package com.example.barbershop.service;

import com.example.barbershop.entity.ProcedureEntity;
import com.example.barbershop.repository.ProcedureRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProcedureService {

    private final ProcedureRepository procedureRepository;


    public ProcedureEntity findProcedureEntityById(Integer id){
        return procedureRepository.findAllById(id);
    }

}
