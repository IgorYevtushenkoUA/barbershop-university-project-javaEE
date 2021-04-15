package com.example.barbershop;

import com.example.barbershop.service.MasterService;
import com.example.barbershop.service.ProcedureService;
import com.example.barbershop.service.RecordService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.Clock;
import java.time.Instant;

@SpringBootApplication
public class BarbershopApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BarbershopApplication.class, args);
        test(applicationContext);
    }

    public static void test(ApplicationContext applicationContext) {
        MasterService masterService = applicationContext.getBean(MasterService.class);
        ProcedureService procedureService = applicationContext.getBean(ProcedureService.class);
        RecordService recordService = applicationContext.getBean(RecordService.class);

        recordService.addRecord(6, 3, 1, Clock.systemDefaultZone().instant());

    }


}
