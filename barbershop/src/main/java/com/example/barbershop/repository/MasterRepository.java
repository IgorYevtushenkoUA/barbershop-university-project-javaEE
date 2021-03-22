package com.example.barbershop.repository;

import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.entity.MasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MasterRepository extends JpaRepository<MasterEntity, Integer> {

    @Query("select m from MasterEntity m")
    List<? extends AccountEntity> findAllMaster();

    @Query("select m from MasterEntity m where m.levelId in " +
            "(select r.levelId from LevelEntity r where r.name='master')")
    List<? extends AccountEntity> findAllMastersWithLevelMaster();

    @Query("select m from MasterEntity m where m.levelId in " +
            "(select r.levelId from LevelEntity r where r.name='trainee')")
    List<? extends AccountEntity> findAllMastersWithLevelTrainee();

    @Query("select m from MasterEntity m where m.levelId in " +
            "(select r.levelId from LevelEntity r where r.name=:level)")
    List<? extends AccountEntity> findAllMastersWithLevel(@Param("level") String level);

    @Query("select m from MasterEntity m where m.accountId=:accountId")
    MasterEntity findMasterById(@Param("accountId") int accountId);




}
