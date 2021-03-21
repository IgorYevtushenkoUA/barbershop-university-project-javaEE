package com.example.barbershop.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@ToString(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "master")
@Getter
@Setter
@NoArgsConstructor
public class MasterEntity extends AccountEntity {

    @Column(name = "work_experience")
    private Integer workExperience;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "level_id", insertable = false, updatable = false)
    private Integer levelId;
}
