package com.example.barbershop.service;

import com.example.barbershop.entity.StatusEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Service
@RequiredArgsConstructor
public class StatusService {
    private final EntityManager entityManager;

    /**
     * get all statuses
     */
    @Transactional
    public List<StatusEntity> getAllStatuses(){
        System.out.println("getAllStatuses");
        return entityManager.createQuery("SELECT s FROM StatusEntity s", StatusEntity.class)
                .getResultList();
    }

    /**
     * get status by ID
     */
    @Transactional
    public StatusEntity getStatusById(int statusId){

        System.out.println("getStatusById");
        return entityManager.find(StatusEntity.class, statusId);
    }
}
