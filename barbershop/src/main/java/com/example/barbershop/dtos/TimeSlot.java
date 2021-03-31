package com.example.barbershop.dtos;

import com.example.barbershop.InstantJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class TimeSlot {
    @JsonSerialize(using = InstantJsonSerializer.class)
    Instant time;
    boolean free;
}
