package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "record")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecordEntity {

    @Id
    @Column(name = "record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;

    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Integer clientId;

    @JoinColumn(name = "master_id", insertable = false, updatable = false)
    private Integer masterId;

    @JoinColumn(name = "procedure_id", insertable = false, updatable = false)
    private Integer procedureId;

    @Column(name = "record_time")
    private Date recordTime;

    @JoinColumn(name = "status_id", insertable = false, updatable = false)
    private Integer statusId;

    @Column(name = "procedure_time_record")
    private Date procedureTimeRecord;





}
