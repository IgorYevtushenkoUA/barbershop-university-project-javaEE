package com.example.barbershop.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ProcedureDto {
    final Integer procedureId;
    final String name;
    final Integer duration;
    final Integer price;
}
