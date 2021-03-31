package com.example.barbershop.controllers;

import com.example.barbershop.dtos.MasterDto;
import com.example.barbershop.exceptions.EntityNotExistsException;
import com.example.barbershop.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MasterController {
    private final MasterService masters;

    @RequestMapping("/masters")
    public Iterable<MasterDto> getMasters(Integer procedureId){
        return masters.findAllMaster(procedureId);
    }

    @RequestMapping("/masters/{id}")
    public MasterDto getMaster(@PathVariable String id){
        return masters.findMasterById(Integer.parseInt(id)).orElseThrow(() -> new EntityNotExistsException(id));
    }
}
