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
        testExam(applicationContext);
    }

    public static void accountExam(ApplicationContext applicationContext){
        AccountService accountService = applicationContext.getBean(AccountService.class);

        accountService.createAccount(
                "testAccdountEmail2@gmail.com",
                "testAccount2Password",
                1,
                "000-00-07",
                "testAccount2",
                "testAccount2",
                "testAccount2",
                21,
                'W'
                );
    }

    public static void testExam(ApplicationContext applicationContext){
        TestService testService = applicationContext.getBean(TestService.class);

        testService.add("test3");
    }

}
