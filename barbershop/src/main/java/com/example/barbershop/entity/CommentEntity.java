package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "comment")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {

    @Id
    @Column(name="record_id")
    private Integer recordId;

    @Column(name = "user_comment")
    private String userComment;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment_time")
    private Instant commentTime;

    @OneToOne()
    @JoinColumn(name = "record_id", insertable = false, updatable = false)
    @ToString.Exclude private RecordEntity record;
}
