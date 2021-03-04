package com.example.barbershop.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column(name = "email", length=128, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Integer roleId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    // may change char -> String xz
    @Column(name = "gender")
    private char gender;

}
