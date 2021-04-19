package com.example.barbershop.controllers;

import com.example.barbershop.dtos.ProcedureDto;
import com.example.barbershop.exceptions.EntityNotExistsException;
import com.example.barbershop.service.ProcedureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ProcedureController {
    private final ProcedureService procedures;

    @RequestMapping("/procedures")
    public Iterable<? extends ProcedureDto> getProcedures(@RequestParam Optional<Integer> priceFrom, @RequestParam Optional<Integer> priceTo,
                                                @RequestParam Optional<String> sort) {
        return procedures.findAllProcedures(priceFrom, priceTo, sort);
    }

    @RequestMapping("/procedures/{id}")
    public ProcedureDto getProcedure(@PathVariable String id) {
        return procedures.findProcedureById(Integer.parseInt(id)).orElseThrow(() -> new EntityNotExistsException(id));
    }
}
