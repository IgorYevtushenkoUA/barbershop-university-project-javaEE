package com.example.barbershop.service;

import com.example.barbershop.entity.LevelEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelService {
    private final EntityManager entityManager;

    /**
     * get all levels
     */
    @Transactional
    public List<LevelEntity> getAllLevels(){
        System.out.println("getAllRoles");
        return entityManager.createQuery("SELECT l FROM LevelEntity l", LevelEntity.class)
                .getResultList();
    }

    /**
     * get level by ID
     */
    @Transactional
    public LevelEntity getLevelById(int levelId){

        System.out.println("getLevelById");
        return entityManager.find(LevelEntity.class, levelId);
    }
}
