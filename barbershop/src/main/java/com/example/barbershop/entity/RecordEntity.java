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

    @Column(name = "client_id", insertable = false, updatable = false)
    private Integer clientId;

    @Column(name = "master_id", insertable = false, updatable = false)
    private Integer masterId;

    @Column(name = "procedure_id", insertable = false, updatable = false)
    private Integer procedureId;

    @Column(name = "record_time")
    private Date recordTime;

    @Column(name = "status_id", insertable = false, updatable = false)
    private Integer statusId;

    @Column(name = "procedure_time_record")
    private Date procedureTimeRecord;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", insertable = false, updatable = false)
    @ToString.Exclude private StatusEntity status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id", referencedColumnName = "comment_id")
    private CommentEntity comment;


}
