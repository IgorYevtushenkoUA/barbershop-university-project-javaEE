package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@AllArgsConstructor()
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MasterHasProcedureId implements Serializable {

    @Column(name = "master_id")
    private Integer masterId;

    @Column(name = "procedure_id")
    private Integer procedureId;

}
