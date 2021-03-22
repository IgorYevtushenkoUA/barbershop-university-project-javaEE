package com.example.barbershop.service;

import com.example.barbershop.entity.CommentEntity;
import com.example.barbershop.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<CommentEntity> findAllComments() {
        return commentRepository.findAllComments();
    }


    public List<CommentEntity> findAllCommentsByProcedure(int procedureId) {
        return commentRepository.findAllCommentsByProcedure(procedureId);
    }


    public List<CommentEntity> findAllCommentsByMaster(int masterId) {
        return commentRepository.findAllCommentsByMaster(masterId);
    }

    public List<CommentEntity> findAllClientComments(int clientId) {
        return commentRepository.findAllClientComments(clientId);
    }

    public CommentEntity findCommentById(int commentId) {
        return commentRepository.findCommentById(commentId);
    }

    public void addNewComment(CommentEntity comment) {
        commentRepository.save(comment);
    }

    public void deleteCommentById(int commentId) {
        commentRepository.deleteById(commentId);
    }

}
