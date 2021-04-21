package com.example.barbershop.repository;

import com.example.barbershop.entity.CommentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer>, CommentRepositoryCustom {

    @Query("select c from CommentEntity c")
    List<CommentEntity> findAllComments();

    @Query("select c from CommentEntity c where c.recordId in (select r from RecordEntity r where r.procedureId =:procedureId)")
    public List<CommentEntity> findAllCommentsByProcedure(@Param("procedureId") int procedureId);

    <T> List<T> findAllByRecord_MasterId(@Param("masterId") int masterId, Class<T> returnType);

    @Query("select c from CommentEntity c where c.recordId in (select r from RecordEntity r where r.clientId =:clientId)")
    List<CommentEntity> findAllClientComments(@Param("clientId") int clientId);

    @Query("select c from CommentEntity c where c.recordId=:recordId")
    <T> T findCommentById(@Param("recordId") int recordId, Class<T> returnType);

    @Query(value = """
select avg(c.rating)
from comment c inner join record r on r.record_id = c.record_id
where r.master_id = :masterId
""", nativeQuery = true)
    Double getRatingForMaster(@Param("masterId") int masterId);
}

interface CommentRepositoryCustom {
    void refresh(CommentEntity commentEntity);
}

@RequiredArgsConstructor
class CommentRepositoryCustomImpl implements CommentRepositoryCustom {
    private final EntityManager entityManager;
    @Override
    public void refresh(CommentEntity commentEntity) {
        entityManager.refresh(entityManager.merge(commentEntity));
    }
}