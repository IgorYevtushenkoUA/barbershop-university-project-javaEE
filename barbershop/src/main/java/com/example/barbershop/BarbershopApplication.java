package com.example.barbershop;

import com.example.barbershop.dtos.MasterDto;
import com.example.barbershop.entity.LevelEntity;
import com.example.barbershop.entity.MasterEntity;
import com.example.barbershop.entity.ProcedureEntity;
import com.example.barbershop.repository.MasterRepository;
import com.example.barbershop.repository.ProcedureRepository;
import com.example.barbershop.service.AccountService;
import com.example.barbershop.service.MasterService;
import com.example.barbershop.service.ProcedureService;
import com.example.barbershop.service.RecordService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Clock;
import java.time.Instant;
import java.util.List;

@SpringBootApplication
public class BarbershopApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = SpringApplication.run(BarbershopApplication.class, args);
        BarbershopApplication ba = new BarbershopApplication();
        RecordService recordService = applicationContext.getBean(RecordService.class);
        recordService.removeAllByClientId(6);


        MasterService masterService = applicationContext.getBean(MasterService.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
        MasterEntity master = new MasterEntity();
        master.setFirstName("fname");
        master.setLastName("lName");
        master.setAge(123);
        master.setGender('w');
        master.setEmail("sdfsdfdsfd");
        master.setPassword("sdfsdfsdf");
        master.setWorkExperience(12);
        master.setRating(4.2);
        master.setPhoneNumber("45456465");

        masterService.addMaster(master);

        System.out.println( masterService.findAllMaster());
    }
}
