package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer procedureId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "duration")
    private Integer duration;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "procedure" )
    @ToString.Exclude private List<MasterEntity> mastersProcedure;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "procedure" )
    @ToString.Exclude private List<RecordEntity> recordsProcedure;

}
