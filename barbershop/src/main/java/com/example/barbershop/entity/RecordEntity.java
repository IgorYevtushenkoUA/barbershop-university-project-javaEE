package com.example.barbershop.entity;

import com.example.barbershop.dtos.TimeSlot;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@SqlResultSetMapping(
        name="timeSlotMapping",
        classes={
                @ConstructorResult(
                        targetClass= TimeSlot.class,
                        columns={
                                @ColumnResult(name="time", type = Instant.class),
                                @ColumnResult(name="free", type = boolean.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name = "RecordEntity.getFreeTimeSlots",
        resultSetMapping = "timeSlotMapping",
        query = """
WITH ProcedureDuration AS (
    select make_interval(mins => (
        select duration
        from procedure
        where procedure_id = :procedure))
),
TimeSlots AS (
    SELECT generate_series(
                   cast(:start as timestamp),
                   cast(:end as timestamp) - (select * from ProcedureDuration),
                    (select * from ProcedureDuration)) AS "from",
           generate_series(
                   cast(:start as timestamp) + (select * from ProcedureDuration),
                   cast(:end as timestamp),
                    (select * from ProcedureDuration)) AS "to"
)

SELECT "from" as "time",
       cast(Not EXISTS(Select *
              from record
              where master_id = :master
                    and ("from", "to") Overlaps (procedure_start, procedure_finish)
                  ) as bool) AS "free"
from TimeSlots;
"""
)

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
    private Instant recordTime;

    @JoinColumn(name = "status_id", insertable = false, updatable = false)
    private Integer statusId;

    @Column(name = "procedure_start")
    private Instant procedureStart;

    @Column(name = "procedure_finish")
    private Instant procedureFinish;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "status_id", insertable = false, updatable = false)
//    @ToString.Exclude private StatusEntity status;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "record")
//    @ToString.Exclude private List<CommentEntity> comment;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "master_id", insertable = false, updatable = false)
//    @ToString.Exclude private MasterEntity master;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "account_id", insertable = false, updatable = false)
//    @ToString.Exclude private AccountEntity account;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "procedure_id", insertable = false, updatable = false)
//    @ToString.Exclude private ProcedureEntity procedure;

}
