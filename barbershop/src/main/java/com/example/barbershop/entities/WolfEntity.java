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
@Table(name = "wolfs")
@Getter
@Setter
@NoArgsConstructor
public class WolfEntity extends Animal {

    @Column(name = "live_region")
    private String liveRegion;

}
