//package com.example.barbershop.entity;
//
//import lombok.*;
//import lombok.experimental.SuperBuilder;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "master")
//
//@Getter
//@Setter
//@NoArgsConstructor
//@ToString(callSuper = true)
//public class MasterEntity extends AccountEntity{
//
//    @Column(name = "work_experience")
//    private Integer workExperience;
//
//    @Column(name = "rating")
//    private Integer rating;
//
//    @Column(name = "level_id", insertable = false, updatable = false)
//    private Integer levelId;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "level_id", insertable = false, updatable = false)
//    @ToString.Exclude private LevelEntity level;
//
////    @ManyToMany(fetch = FetchType.EAGER)
////    @JoinTable(name = "master_has_procedure",
////            joinColumns = @JoinColumn(name = "master_id"),
////            inverseJoinColumns = @JoinColumn(name = "procedure_id"))
////    private List<ProcedureEntity> procedures;
//
////    @OneToMany(fetch = FetchType.LAZY, mappedBy = "master" )
////    @ToString.Exclude private List<RecordEntity> recordersMaster;
//
//}
