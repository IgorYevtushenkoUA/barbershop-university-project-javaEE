package com.example.barbershop.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommentEntity {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer commentId;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "user_comment")
    private String userComment;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment_time")
    private Date commentTime;

}
