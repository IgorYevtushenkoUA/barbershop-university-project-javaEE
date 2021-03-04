package com.example.barbershop.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "test1")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TestEntity {

    @Id
    @Column(name = "test_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;

    @Column(name = "name")
    private String name;
}
