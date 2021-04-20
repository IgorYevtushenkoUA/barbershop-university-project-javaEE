package com.example.barbershop.controllers;

import com.example.barbershop.dtos.MasterDto;
import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.entity.MasterEntity;
import com.example.barbershop.exceptions.EntityNotExistsException;
import com.example.barbershop.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MasterController {
    private final MasterService masters;

    @GetMapping("/masters")
    public Iterable<MasterDto> getMasters(Integer procedureId){
        return masters.findAllMaster(procedureId);
    }

    @GetMapping("/admin/masters/all")
    public List<MasterDto> getAllMasters(){
       return  null;
    }

    @GetMapping("/masters/{id}")
    public MasterDto getMaster(@PathVariable String id){
        return masters.findMasterById(Integer.parseInt(id)).orElseThrow(() -> new EntityNotExistsException(id));
    }

    @DeleteMapping("/admin/master/{id}")
    public void deleteMaster(@PathVariable String id){
        masters.deleteMasterById(Integer.parseInt(id));
    }
}
