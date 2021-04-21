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
    private final MasterService masterService;
    private final RecordService recordService;

    public List<CommentEntity> findAllComments() {
        return commentRepository.findAllComments();
    }


    public List<CommentEntity> findAllCommentsByProcedure(int procedureId) {
        return commentRepository.findAllCommentsByProcedure(procedureId);
    }


    public <T> List<T> findAllCommentsByMaster(int masterId, Class<T> returnType) {
        return commentRepository.findAllByRecord_MasterId(masterId, returnType);
    }

    public List<CommentEntity> findAllClientComments(int clientId) {
        return commentRepository.findAllClientComments(clientId);
    }

    public <T> T findCommentById(int commentId, Class<T> returnType) {
        return commentRepository.findCommentById(commentId, returnType);
    }

    public void addNewComment(CommentEntity comment, int account) {
        commentRepository.save(comment);
        var record = recordService.findCustomerRecordById(comment.getRecordId(), account);
        var masterId = record.getMaster().getId();
        masterService.updateMasterRating(masterId, commentRepository.getRatingForMaster(masterId));
    }

    public void deleteCommentById(int commentId) {
        commentRepository.deleteById(commentId);
    }

}
