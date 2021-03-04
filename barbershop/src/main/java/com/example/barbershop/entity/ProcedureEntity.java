package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "procedure")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProcedureEntity {

    @Id
    @Column(name = "procedure_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer procedureId;

    @Column(name = "name")
    private String name;

    // todo change in database to int
    @Column(name = "price")
    private double price;

    @Column(name = "duration")
    private int duration;

}
