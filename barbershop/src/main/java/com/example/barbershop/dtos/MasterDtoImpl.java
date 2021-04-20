package com.example.barbershop.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MasterDtoImpl implements MasterDto{
    final Integer accountId;
    final Double rating;
    final Integer levelId;
    final Integer workExperience;
    final String firstName;
    final String secondName;
    final String lastName;
    final String photo;
}
