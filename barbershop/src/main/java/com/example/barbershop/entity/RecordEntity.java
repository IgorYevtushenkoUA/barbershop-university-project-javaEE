//package com.example.barbershop.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Table(name = "record")
//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//public class RecordEntity {
//
//    @Id
//    @Column(name = "record_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer recordId;
//
//    @Column(name = "client_id", insertable = false, updatable = false)
//    private Integer clientId;
//
//    @Column(name = "master_id", insertable = false, updatable = false)
//    private Integer masterId;
//
//    @Column(name = "procedure_id", insertable = false, updatable = false)
//    private Integer procedureId;
//
//    @Column(name = "record_time")
//    private Date recordTime;
//
//    @Column(name = "status_id", insertable = false, updatable = false)
//    private Integer statusId;
//
//    @Column(name = "procedure_time_record")
//    private Date procedureTimeRecord;
//
////    @ManyToOne(fetch = FetchType.EAGER)
////    @JoinColumn(name = "status_id", insertable = false, updatable = false)
////    @ToString.Exclude private StatusEntity status;
////
////    @OneToMany(fetch = FetchType.LAZY, mappedBy = "record")
////    @ToString.Exclude private List<CommentEntity> comment;
////
////    @ManyToOne(fetch = FetchType.EAGER)
////    @JoinColumn(name = "master_id", insertable = false, updatable = false)
////    @ToString.Exclude private MasterEntity master;
////
////    @ManyToOne(fetch = FetchType.EAGER)
////    @JoinColumn(name = "account_id", insertable = false, updatable = false)
////    @ToString.Exclude private AccountEntity account;
////
////    @ManyToOne(fetch = FetchType.EAGER)
////    @JoinColumn(name = "procedure_id", insertable = false, updatable = false)
////    @ToString.Exclude private ProcedureEntity procedure;
//
//}
