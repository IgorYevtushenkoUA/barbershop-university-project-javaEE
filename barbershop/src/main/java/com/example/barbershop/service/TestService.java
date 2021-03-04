package com.example.barbershop.service;

import com.example.barbershop.entity.TestEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TestService {

    private final EntityManager entityManager;

    @Transactional
    public void add(String name) {
        TestEntity testEntity = new TestEntity();
        testEntity.setName(name);

        entityManager.persist(testEntity);
    }

}
