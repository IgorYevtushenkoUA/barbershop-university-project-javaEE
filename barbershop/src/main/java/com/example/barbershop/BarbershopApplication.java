package com.example.barbershop;

import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.service.AccountService;
import com.example.barbershop.service.RoleService;
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
//        System.out.println(accountService.findAccountById(1));
//        System.out.println(accountService.findAllAccounts());
//        System.out.println(accountService.findAllMasterByRole());

//        RoleService roleService = applicationContext.getBean(RoleService.class);
//        System.out.println(roleService.findAllRoles());

    }
}
