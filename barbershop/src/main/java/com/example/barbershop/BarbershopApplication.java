package com.example.barbershop;

import com.example.barbershop.entity.AccountEntity;
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


    }
}
