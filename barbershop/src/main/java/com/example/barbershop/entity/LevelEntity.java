package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer levelId;

    @Column(name = "name")
    private String name;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "level")
//    @ToString.Exclude
//    private List<AccountEntity> mastersLevel;

}
