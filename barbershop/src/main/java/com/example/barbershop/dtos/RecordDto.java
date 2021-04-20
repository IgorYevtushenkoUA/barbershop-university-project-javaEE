package com.example.barbershop.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
public class RecordDto {
    private Integer clientId;
    @NotNull
    private Integer masterId;
    @NotNull
    private Integer procedureId;
    @NotNull
    private Instant dateTime;
}
