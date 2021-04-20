package com.example.barbershop;

import com.example.barbershop.dtos.MasterDto;
import com.example.barbershop.entity.LevelEntity;
import com.example.barbershop.entity.MasterEntity;
import com.example.barbershop.entity.ProcedureEntity;
import com.example.barbershop.repository.MasterRepository;
import com.example.barbershop.repository.ProcedureRepository;
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
//        System.out.println(ba.extractBytes("d:\\image.jpg"));
        ba.test(applicationContext);
    }

    public void test(ApplicationContext applicationContext) throws IOException {

//        MasterService masterService = applicationContext.getBean(MasterService.class);
//        ProcedureService procedureService = applicationContext.getBean(ProcedureService.class);
//        ProcedureRepository procedureRepository = applicationContext.getBean(ProcedureRepository.class);
//        ProcedureEntity procedureEntity = procedureRepository.findById(8).orElse(null);
//        procedureEntity.setName("abagalamaga");
//        procedureService.updateProcedure(procedureEntity);

        RecordService recordService = applicationContext.getBean(RecordService.class);
        recordService.removeAllByClientId(6);


        MasterService masterService = applicationContext.getBean(MasterService.class);
        System.out.println( masterService.findAllMaster());
    }

}
