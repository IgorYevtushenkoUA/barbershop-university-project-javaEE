package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "master_has_procedure")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MasterHasProcedureEntity {

    @EmbeddedId
    private MasterHasProcedureId masterHasProcedureId;

}


