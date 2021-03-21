package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "master")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MasterEntity {

    @Id
    @JoinColumn(name = "master_id") // todo JoinColumn may change -> because
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer masterId;

    @Column(name = "work_experience")
    private Integer workExperience;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "level_id", insertable = false, updatable = false)
    private Integer levelId;

    // in table master_has_procedure
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "procedure_id", insertable = false, updatable = false)
    @ToString.Exclude private ProcedureEntity procedure;

    // FK for level_id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "level_id", insertable = false, updatable = false)
    @ToString.Exclude private LevelEntity level;

}
