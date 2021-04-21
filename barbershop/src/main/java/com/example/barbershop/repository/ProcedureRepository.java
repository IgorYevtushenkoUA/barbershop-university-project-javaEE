package com.example.barbershop.repository;

import com.example.barbershop.dtos.ProcedureDto;
import com.example.barbershop.entity.ProcedureEntity;
import com.example.barbershop.entity.QProcedureEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Integer>, ProcedureRepositoryCustom {

    <T> Optional<T> findByProcedureId(Integer procedureId, Class<T> returnType);
    <T> List<T> findBy(Class<T> returnType);
}

interface ProcedureRepositoryCustom {
    List<? extends ProcedureDto> findProcedures(Optional<Integer> priceFrom, Optional<Integer> priceTo, Optional<String> sort);
}

@RequiredArgsConstructor
class ProcedureRepositoryCustomImpl implements ProcedureRepositoryCustom {
    private final EntityManager entityManager;

    @Override
    public List<ProcedureDto> findProcedures(Optional<Integer> priceFrom, Optional<Integer> priceTo, Optional<String> sort) {
        var procedure = QProcedureEntity.procedureEntity;
        var query = new JPAQuery<QProcedureEntity>(entityManager).from(procedure);
        if (priceFrom.isPresent())
            query = query.where(procedure.price.goe(priceFrom.get()));
        if (priceTo.isPresent())
            query = query.where(procedure.price.loe(priceTo.get()));
        if (sort.isPresent())
            query = switch (sort.get()) {
                case "price asc" -> query.orderBy(procedure.price.asc());
                case "price desc" -> query.orderBy(procedure.price.desc());
                case "duration asc" -> query.orderBy(procedure.duration.asc());
                case "duration desc" -> query.orderBy(procedure.duration.desc());
                default -> throw new IllegalStateException("Unexpected value: " + sort.get());
            };
        return query.select(Projections.constructor(ProcedureDto.class,
                procedure.procedureId, procedure.name, procedure.duration, procedure.price)).fetch();
    }
}