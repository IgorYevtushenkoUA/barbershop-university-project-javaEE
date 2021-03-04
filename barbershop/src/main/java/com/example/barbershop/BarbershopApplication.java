package com.example.barbershop;

import com.example.barbershop.service.AccountService;
import com.example.barbershop.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BarbershopApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =SpringApplication.run(BarbershopApplication.class, args);
        accountExam(applicationContext);
    }

    public static void accountExam(ApplicationContext applicationContext){
        AccountService accountService = applicationContext.getBean(AccountService.class);
        accountService.deleteAccountById(14);
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

    public static void testExam(ApplicationContext applicationContext){
        TestService testService = applicationContext.getBean(TestService.class);

        testService.add("test3");
    }

}
