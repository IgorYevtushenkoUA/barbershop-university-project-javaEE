package com.example.barbershop.service;

import com.example.barbershop.entity.RoleEntity;
import com.example.barbershop.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleService {

    public final RoleRepository roleRepository;

    public List<RoleEntity> findAllRoles(){
        return roleRepository.findAll();
    }

}
