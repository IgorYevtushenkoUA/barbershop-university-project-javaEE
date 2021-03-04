package com.example.barbershop;

import com.example.barbershop.entity.CommentEntity;
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

        CommentService recordService = applicationContext.getBean(CommentService.class);
        System.out.println(recordService.getAllComments());

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
