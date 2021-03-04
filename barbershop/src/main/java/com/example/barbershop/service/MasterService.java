package com.example.barbershop.service;

import com.example.barbershop.entity.MasterEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MasterService {
    private final EntityManager entityManager;

    @Transactional
    public List<MasterEntity> getAllMasters() {
        System.out.println("getAllMasters");
        return entityManager.createQuery("SELECT m FROM MasterEntity m", MasterEntity.class)
                .getResultList();
    }

    @Transactional
    public MasterEntity getMasterById(int masterId) {
        System.out.println("getMasterById");
        return entityManager.find(MasterEntity.class, masterId);
    }

    // todo
    /** update master */


}
