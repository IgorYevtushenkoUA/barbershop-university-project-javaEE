package com.example.barbershop;

import com.example.barbershop.service.AccountService;
import com.example.barbershop.service.LevelService;
import com.example.barbershop.service.RoleServices;
import com.example.barbershop.service.StatusService;
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

        StatusService roleServices = applicationContext.getBean(StatusService.class);
        System.out.println(roleServices.getAllStatuses());
        System.out.println(roleServices.getStatusById(1));

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
