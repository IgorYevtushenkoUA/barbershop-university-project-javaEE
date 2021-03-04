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

    @JoinColumn(name = "level_id", insertable = false, updatable = false)
    private Integer levelId;
}
