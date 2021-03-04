package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;

@Embeddable
@Table(name = "master_has_procedure")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MasterHasProcedureEntity {

    @Column(name="master_id")
    private Integer masterId;

    @Column(name="procedure_id")
    private Integer procedureId;
    
}
