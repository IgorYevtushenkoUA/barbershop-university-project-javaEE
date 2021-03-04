package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderEntity {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @Column(name = "client_id")
    private Integer client_id;

    @Column(name = "master_id")
    private Integer masterId;

    @Column(name = "procedure_id")
    private int procedureId;

    @Column(name = "order_time")
    private Date orderTime;

    @Column(name = "status_id")
    private int status_id;

    @Column(name = "procedure_time_order")
    private Date procedureTimeOrder;

}
