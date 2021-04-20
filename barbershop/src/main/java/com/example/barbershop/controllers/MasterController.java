package com.example.barbershop.controllers;

import com.example.barbershop.dtos.MasterDto;
import com.example.barbershop.exceptions.EntityNotExistsException;
import com.example.barbershop.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MasterController {
    private final MasterService masters;

    @RequestMapping("/masters")
    public Iterable<? extends MasterDto> getMasters(@RequestParam Integer procedureId, @RequestParam Optional<Integer> levelId,
                                          @RequestParam Optional<String> sort) {
        return masters.findAllMaster(procedureId, levelId, sort);
    }

    @RequestMapping("/masters/{id}")
    public MasterDto getMaster(@PathVariable String id) {
        return masters.findMasterById(Integer.parseInt(id)).orElseThrow(() -> new EntityNotExistsException(id));
    }
}
