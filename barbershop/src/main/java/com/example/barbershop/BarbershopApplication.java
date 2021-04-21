package com.example.barbershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class BarbershopApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = SpringApplication.run(BarbershopApplication.class, args);
        BarbershopApplication ba = new BarbershopApplication();
    }

}
