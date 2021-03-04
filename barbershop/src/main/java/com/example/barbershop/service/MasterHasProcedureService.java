package com.example.barbershop.service;

import com.example.barbershop.entity.MasterHasProcedureEntity;
import com.example.barbershop.entity.MasterHasProcedureId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MasterHasProcedureService {

    private final EntityManager entityManager;

    /**
     * get all master has procedure
     */
    @Transactional
    public List<MasterHasProcedureEntity> getAllMasterHasProcedure() {
        System.out.println("getAllMasterHasProcedure");
        return entityManager.createQuery("SELECT mhp FROM MasterHasProcedureEntity mhp", MasterHasProcedureEntity.class)
                .getResultList();
    }

    /**
     * get master has procedure by masterId
     */
    @Transactional
    public List<MasterHasProcedureEntity> getMasterHasProcedureByMasterId(int masterId) {
        System.out.println("getMasterHasProcedureByMasterId");
        return entityManager.createQuery("SELECT mhp FROM MasterHasProcedureEntity mhp WHERE mhp.masterHasProcedureId.masterId =: masterId", MasterHasProcedureEntity.class)
                .setParameter("masterId", masterId)
                .getResultList();
    }

    /**
     * get master has procedure by procedureId
     */
    @Transactional
    public List<MasterHasProcedureEntity> getMasterHasProcedureByProcedureId(int procedureId) {
        System.out.println("getMasterHasProcedureByMasterId");
        return entityManager.createQuery("SELECT mhp FROM MasterHasProcedureEntity mhp WHERE mhp.masterHasProcedureId.procedureId= : procedureId", MasterHasProcedureEntity.class)
                .setParameter("procedureId", procedureId)
                .getResultList();
    }

    /**
     * todo check method
     * edit  masters procedure
     */
    @Transactional
    public void editMasterHasProcedure(int masterId, int oldProcedureId, int newProcedureId) {
        System.out.println("editMasterHasProcedure");
        MasterHasProcedureEntity updatedMasterHasEntity = new MasterHasProcedureEntity(new MasterHasProcedureId(masterId, newProcedureId));
        // delete old
        deleteMasterHasProcedure(masterId, oldProcedureId);
        // add new
        addMasterHasProcedure(masterId, oldProcedureId);
    }

    /**
     * todo check method
     * delete masterHasProcedure by masterId, procedureId
     */
    @Transactional
    public void deleteMasterHasProcedure(int masterId, int procedureId) {
        System.out.println("deleteMasterHasProcedure");
        entityManager.createQuery("DELETE FROM MasterHasProcedureEntity mhp " +
                "WHERE mhp.masterHasProcedureId.masterId=:masterId " +
                "AND mhp.masterHasProcedureId.procedureId= :procedureId")
                .setParameter("masterId", masterId)
                .setParameter("procedureId", procedureId)
                .executeUpdate();
    }

    /** todo check method
     * delete masterHasProcedure by masterId, procedureId
     */
    @Transactional
    public void addMasterHasProcedure(int masterId, int procedureId) {
        System.out.println("addMasterHasProcedure");
        MasterHasProcedureEntity masterHasProcedureEntity = new MasterHasProcedureEntity(new MasterHasProcedureId(masterId, procedureId));
        // todo check if contains
        entityManager.merge(masterHasProcedureEntity);
    }

}
