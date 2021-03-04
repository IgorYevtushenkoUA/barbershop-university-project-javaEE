package com.example.barbershop.service;

import com.example.barbershop.entity.CommentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {


    private final EntityManager entityManager;

    /**
     * get all comments
     */
    @Transactional
    public List<CommentEntity> getAllComments() {
        System.out.println("getAllComments");
        return entityManager.createQuery("SELECT c FROM CommentEntity c", CommentEntity.class)
                .getResultList();
    }


    /**
     * get comment by id
     */
    @Transactional
    public CommentEntity getCommentByCommentId(int commentId) {
        System.out.println("getCommentByCommentId");
        return entityManager.find(CommentEntity.class, commentId);
    }

    // todo test method
    /** find comment by orderId */
    public CommentEntity getCommentByOrderId(int orderId) {
        System.out.println("getCommentByOrderId");
        return entityManager.find(CommentEntity.class, orderId);
    }

    // todo
    /** find comment by group or orders*/

}
