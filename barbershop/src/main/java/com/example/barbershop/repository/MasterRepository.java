//package com.example.barbershop.repository;
//
//import com.example.barbershop.entity.AccountEntity;
//import com.example.barbershop.entity.MasterEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface MasterRepository extends JpaRepository<MasterEntity, Integer> {
//
//    @Query("select m from MasterEntity m")
//    List<? extends AccountEntity> findAllMaster();
//
//
//}
