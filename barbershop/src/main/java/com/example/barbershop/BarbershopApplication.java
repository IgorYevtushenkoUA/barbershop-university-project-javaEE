package com.example.barbershop;

import com.example.barbershop.entity.AccountEntity;
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

        AccountService accountService = applicationContext.getBean(AccountService.class);
        AccountEntity account = accountService.getAccountByEmailAndPassword("admin@gmail.com", "password");
        System.out.println(account);
        System.out.println(account.getRole());

    }
}
