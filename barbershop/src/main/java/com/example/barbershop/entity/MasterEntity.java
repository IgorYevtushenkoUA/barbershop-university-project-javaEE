package com.example.barbershop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@ToString(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "master")
@Getter
@Setter
@NoArgsConstructor
//@PrimaryKeyJoinColumn(name = "account_id")
public class MasterEntity extends AccountEntity {

    @Column(name = "work_experience")
    private Integer workExperience;

    @Column(name = "rating")
    private Integer rating;

//    @EmbeddedId
//    private MasterLevelId masterLevelId;

    @Column(name = "level_id", insertable = false, updatable = false)
    private Integer levelId;

    @OneToOne
    @JoinColumn(name = "level_id")
    private LevelEntity level;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "master_has_procedure",
            joinColumns = @JoinColumn(name = "master_id"),
            inverseJoinColumns = @JoinColumn(name = "procedure_id"))
    private List<ProcedureEntity> procedures;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "level_id", insertable = false, updatable = false)
//    @ToString.Exclude
//    private LevelEntity level;

}


