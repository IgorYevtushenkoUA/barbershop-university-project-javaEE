package com.example.barbershop.repository;

import com.example.barbershop.entity.CommentEntity;
import com.example.barbershop.service.CommentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    @Query("select c from CommentEntity c")
    List<CommentEntity> findAllComments();

    @Query("select c from CommentEntity c where c.recordId in (select r from RecordEntity r where r.procedureId =:procedureId)")
    public List<CommentEntity> findAllCommentsByProcedure(@Param("procedureId") int procedureId);

    @Query("select c from CommentEntity c where c.recordId in (select r from RecordEntity r where r.masterId =:masterId)")
    List<CommentEntity> findAllCommentsByMaster(@Param("masterId") int masterId);

    @Query("select c from CommentEntity c where c.recordId in (select r from RecordEntity r where r.clientId =:clientId)")
    List<CommentEntity> findAllClientComments(@Param("clientId") int clientId);

    @Query("select c from CommentEntity c where c.commentId=:commentId")
    CommentEntity findCommentById(@Param("commentId") int commentId);

    void removeAllByRecordId(Integer recordId);

}
