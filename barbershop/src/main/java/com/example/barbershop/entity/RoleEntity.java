package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoleEntity {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role" )
    @ToString.Exclude private List<AccountEntity> accountsRole;
}
