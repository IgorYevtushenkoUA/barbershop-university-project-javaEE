package com.example.barbershop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@ToString(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "giraffe")
@Getter
@Setter
@NoArgsConstructor
public class GiraffeEntity extends Animal {

    @Column(name = "height")
    private float height;

}
