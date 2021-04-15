package com.example.barbershop.service;

import com.example.barbershop.dtos.ProcedureDto;
import com.example.barbershop.entity.MasterEntity;
import com.example.barbershop.entity.ProcedureEntity;
import com.example.barbershop.repository.ProcedureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProcedureService {

    private final ProcedureRepository procedureRepository;

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

    public List<ProcedureDto> findAllProcedures(Integer priceFrom, Integer priceTo, String sortBy) {
        return sortBy.equals("price asc")
                ? procedureRepository.findDistinctAllByPriceBetweenOrderByPriceAsc(priceFrom, priceFrom, ProcedureDto.class)
                : sortBy.equals("price desc")
                ? procedureRepository.findDistinctAllByPriceBetweenOrderByPriceDesc(priceFrom, priceFrom, ProcedureDto.class)
                : sortBy.equals("duration asc")
                ? procedureRepository.findDistinctAllByPriceBetweenOrderByDurationAsc(priceFrom, priceFrom, ProcedureDto.class)
                : procedureRepository.findDistinctAllByPriceBetweenOrderByDurationDesc(priceFrom, priceFrom, ProcedureDto.class);
    }

}
