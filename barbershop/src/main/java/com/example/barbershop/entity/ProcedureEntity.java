package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "procedure")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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


    @ManyToMany(mappedBy = "procedures")
    @ToString.Exclude private List<MasterEntity> masters;

//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "procedure" )
//    @ToString.Exclude private List<RecordEntity> recordsProcedure;

}
