package com.example.barbershop.repository;

import com.example.barbershop.dtos.MasterDto;
import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.entity.MasterEntity;
import com.example.barbershop.entity.QMasterEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface MasterRepository extends JpaRepository<MasterEntity, Integer>, MasterRepositoryCustom {

    @Query("select m from MasterEntity m")
    List<? extends AccountEntity> findAllMaster();

    <T> Optional<T> findByAccountId(Integer accountId, Class<T> returnType);

    <T> List<T> findByProceduresProcedureId(Integer procedureId, Class<T> returnType);

    <T> List<T> findByLevel_Name(String name, Class<T> returnType);
}

interface MasterRepositoryCustom {
    List<? extends MasterDto> findMasters(Integer procedureId, Optional<Integer> levelId, Optional<String> sort);
}

@RequiredArgsConstructor
class MasterRepositoryCustomImpl implements MasterRepositoryCustom {
    private final EntityManager entityManager;

    @Override
    public List<? extends MasterDto> findMasters(Integer procedureId, Optional<Integer> levelId, Optional<String> sort) {
        var master = QMasterEntity.masterEntity;
        var query = new JPAQuery<QMasterEntity>(entityManager)
                .from(master)
                .where(master.procedures.any().procedureId.eq(procedureId));

        if (levelId.isPresent())
            query = query.where(master.levelId.eq(levelId.get()));
        if (sort.isPresent())
            query = switch (sort.get()) {
                case "rating asc" -> query.orderBy(master.rating.asc());
                case "rating desc" -> query.orderBy(master.rating.desc());
                default -> throw new IllegalStateException("Unexpected value: " + sort.get());
            };
        return query.select(Projections.constructor(MasterDto.class,
                master.accountId, master.rating, master.levelId, master.workExperience,
                master.firstName, master.secondName, master.lastName, master.photo)).fetch();
    }
}