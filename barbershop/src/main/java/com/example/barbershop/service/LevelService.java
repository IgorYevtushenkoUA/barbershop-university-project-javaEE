package com.example.barbershop.service;

import com.example.barbershop.entity.LevelEntity;
import com.example.barbershop.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LevelService {

    private final LevelRepository levelRepository;

    public List<LevelEntity> findAllLevel(){
        return levelRepository.findAll();
    }

}
