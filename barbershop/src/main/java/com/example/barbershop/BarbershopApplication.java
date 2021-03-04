package com.example.barbershop;

import com.example.barbershop.entity.CommentEntity;
import com.example.barbershop.entity.MasterHasProcedureEntity;
import com.example.barbershop.entity.RecordEntity;
import com.example.barbershop.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BarbershopApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BarbershopApplication.class, args);
        accountExam(applicationContext);
    }

    public static void accountExam(ApplicationContext applicationContext) {

        MasterHasProcedureService recordService = applicationContext.getBean(MasterHasProcedureService.class);
        System.out.println(recordService.getAllMasterHasProcedure());
        System.out.println(recordService.getMasterHasProcedureByMasterId(2));
        System.out.println(recordService.getMasterHasProcedureByProcedureId(3));

//        AccountService accountService = applicationContext.getBean(AccountService.class);
        //        accountService.updateAccountById(
//                1,
//                "update@gmail.com",
//                "update1",
//                2,
//                "000-00-07",
//                "update1",
//                "update1",
//                "update1",
//                21,
//                'M'
//                );
    }


}
