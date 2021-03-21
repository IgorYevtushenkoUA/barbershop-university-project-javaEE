//package com.example.barbershop.service;
//
//import com.example.barbershop.entity.AccountEntity;
//import com.example.barbershop.entity.MasterEntity;
//import com.example.barbershop.repository.MasterRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class MasterService {
//
//    private final MasterRepository masterRepository;
//
//    public List<? extends AccountEntity> findAllMaster(){
//        return masterRepository.findAllMaster();
//    }
//
////    private final EntityManager entityManager;
////
////    public List<MasterEntity> findAllMaster(){
////        return entityManager.createQuery("select a FROM MasterEntity a", MasterEntity.class)
////                .getResultList();
////    }
//
//}
