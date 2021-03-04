package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "level")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LevelEntity {

    @Id
    @Column(name = "level_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;

    @Column(name = "name")
    private String name;

}
