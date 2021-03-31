package com.example.barbershop.controllers;

import com.example.barbershop.dtos.ProcedureDto;
import com.example.barbershop.exceptions.EntityNotExistsException;
import com.example.barbershop.service.ProcedureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProcedureController {
    private final ProcedureService procedures;

    @RequestMapping("/procedures")
    public Iterable<ProcedureDto> getProcedures(){
        return procedures.getAllProcedures();
    }

    @RequestMapping("/procedures/{id}")
    public ProcedureDto getProcedure(@PathVariable String id){
        return procedures.findProcedureById(Integer.parseInt(id)).orElseThrow(() -> new EntityNotExistsException(id));
    }}
