package com.example.barbershop.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
@Getter
public class RecordInfoDto {
    final Integer clientId;
    final Integer customerId;
    final Instant start;
    final Instant finish;
    final Master master;
    final Procedure procedure;

    @RequiredArgsConstructor
    @Getter
    public static class Master {
        final Integer id;
        final String firstName;
        final String lastName;
        final String secondName;
    }

    @RequiredArgsConstructor
    @Getter
    public static class Procedure {
        final Integer id;
        final String name;
    }
}
