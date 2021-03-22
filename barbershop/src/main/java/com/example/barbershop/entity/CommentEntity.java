package com.example.barbershop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @JoinColumn(name="record_id")
    private Integer recordId;

    @Column(name = "user_comment")
    private String userComment;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment_time")
    private Date commentTime;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "record_id", insertable = false, updatable = false)
//    @ToString.Exclude private RecordEntity record;

}
