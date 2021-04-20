package com.example.barbershop.controllers;

import com.example.barbershop.dtos.MasterDto;
import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.entity.MasterEntity;
import com.example.barbershop.exceptions.EntityNotExistsException;
import com.example.barbershop.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
       return  masters.findAllMasterDto();
    }

    @RequestMapping("/masters")
    public Iterable<? extends MasterDto> getMasters(@RequestParam Integer procedureId, @RequestParam Optional<Integer> levelId,
                                          @RequestParam Optional<String> sort) {
        return masters.findAllMaster(procedureId, levelId, sort);
    }

    @RequestMapping("/masters/{id}")
    public MasterDto getMaster(@PathVariable String id) {
        return masters.findMasterById(Integer.parseInt(id)).orElseThrow(() -> new EntityNotExistsException(id));
    }

    @PostMapping("/admin/master/add")
    public void addMaster(@RequestBody MasterEntity master){
        System.out.println(master.toString());
        masters.addMaster(master);
    }

    @PutMapping("/admin/master/update")
    public void updateMaster(@RequestBody MasterEntity master){
        masters.updateMaster(master);
    }

    @DeleteMapping("/admin/master/{id}")
    public void deleteMaster(@PathVariable int id){
        masters.deleteMasterById(id);
    }
}
