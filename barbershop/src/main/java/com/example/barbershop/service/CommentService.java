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
    public CommentEntity getCommentById(int commentId) {
        System.out.println("getCommentById");
        return entityManager.find(CommentEntity.class, commentId);
    }

}
