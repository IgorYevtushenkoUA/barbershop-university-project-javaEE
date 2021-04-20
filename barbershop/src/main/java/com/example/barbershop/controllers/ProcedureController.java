package com.example.barbershop.controllers;

import com.example.barbershop.dtos.ProcedureDto;
import com.example.barbershop.entity.ProcedureEntity;
import com.example.barbershop.exceptions.EntityNotExistsException;
import com.example.barbershop.service.MasterService;
import com.example.barbershop.service.ProcedureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProcedureController {
    private final ProcedureService procedures;
    private final MasterService master;

    @GetMapping("/procedures")
    public Iterable<ProcedureDto> getProcedures(){
        return procedures.getAllProcedures();
    }

    @GetMapping("/procedures/{id}")
    public ProcedureDto getProcedure(@PathVariable String id){
        return procedures.findProcedureById(Integer.parseInt(id)).orElseThrow(() -> new EntityNotExistsException(id));
    }

    @PostMapping("/client/procedure/add")
    public void addProcedure(@RequestBody ProcedureEntity procedure){
        master.addToMasterProcedure(null,procedure);
    }

    @DeleteMapping("/admin/procedure/delete/{id}")
    public void deleteProcedure(@PathVariable int id){
        procedures.deleteInProcedureMasters(id);
    }

    @PutMapping("/admin/procedure/update")
    public void updateProcedure(@RequestBody ProcedureEntity procedure){
        procedures.updateProcedure(procedure);
    }

}


