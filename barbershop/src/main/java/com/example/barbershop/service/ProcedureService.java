package com.example.barbershop.service;

import com.example.barbershop.dtos.MasterDto;
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
    private final MasterRepository masterRepository;
    private final MasterService masterService;

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

    public void deleteInProcedureMasters(int procedureId) {
        ProcedureEntity procedure = procedureRepository.findById(procedureId).orElse(null);
        procedure.setMasters(new ArrayList<>());
        procedureRepository.save(procedure);
    }

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

}
