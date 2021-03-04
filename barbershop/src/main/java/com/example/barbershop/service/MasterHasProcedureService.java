package com.example.barbershop.service;

import com.example.barbershop.entity.MasterHasProcedureEntity;
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
        return entityManager.createQuery("SELECT mhp FROM MasterHasProcedureEntity mhp WHERE mhp.masterHasProcedureId.masterId =: masterId")
                .setParameter("masterId", masterId)
                .getResultList();
    }

    /**
     * get master has procedure by procedureId
     */
    public List<MasterHasProcedureEntity> getMasterHasProcedureByProcedureId(int procedureId) {
        System.out.println("getMasterHasProcedureByMasterId");
        return entityManager.createQuery("SELECT mhp FROM MasterHasProcedureEntity mhp WHERE mhp.masterHasProcedureId.procedureId= : procedureId")
                .setParameter("procedureId", procedureId)
                .getResultList();
    }


}
