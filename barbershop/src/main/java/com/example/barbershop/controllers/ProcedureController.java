package com.example.barbershop.controllers;

import com.example.barbershop.dtos.ProcedureDto;
import com.example.barbershop.entity.ProcedureEntity;
import com.example.barbershop.exceptions.EntityNotExistsException;
import com.example.barbershop.service.ProcedureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProcedureController {
    private final ProcedureService procedures;

    @GetMapping("/procedures")
    public Iterable<ProcedureDto> getProcedures(){
        return procedures.getAllProcedures();
    }

    @GetMapping("/procedures/{id}")
    public ProcedureDto getProcedure(@PathVariable String id){
        return procedures.findProcedureById(Integer.parseInt(id)).orElseThrow(() -> new EntityNotExistsException(id));
    }

    @DeleteMapping("/procedure/delete/{id}")
    public void deleteProcedure(@PathVariable int id){
        procedures.deleteInMasterProcedure(id);
    }

    @PutMapping("/procedure/update")
    public void updateProcedure(@RequestBody ProcedureEntity procedure){
        procedures.updateProcedure(procedure);
    }

}


