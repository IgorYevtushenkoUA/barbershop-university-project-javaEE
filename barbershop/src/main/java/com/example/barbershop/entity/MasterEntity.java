package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "master")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MasterEntity {

    // todo change PK to FK -> xz
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;

    @Column(name = "work_experience")
    private int name;

    // todo change in database to int
    @Column(name = "rating")
    private double rating;

    @Column(name = "level_id")
    private int level_id;
}
