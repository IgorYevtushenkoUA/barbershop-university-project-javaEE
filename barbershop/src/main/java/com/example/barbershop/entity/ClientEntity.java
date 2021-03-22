package com.example.barbershop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@ToString(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class ClientEntity extends AccountEntity{

}
