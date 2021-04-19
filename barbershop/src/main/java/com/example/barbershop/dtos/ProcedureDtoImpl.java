package com.example.barbershop.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ProcedureDtoImpl implements ProcedureDto {
    final Integer procedureId;
    final String name;
    final Integer duration;
    final Integer price;
}
