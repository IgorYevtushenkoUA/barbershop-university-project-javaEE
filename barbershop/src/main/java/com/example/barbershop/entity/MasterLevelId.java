package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MasterLevelId implements Serializable {
    @Column(name="level_id")
    private Integer levelId;
}
