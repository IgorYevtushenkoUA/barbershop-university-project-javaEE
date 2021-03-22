package com.example.barbershop;

import com.example.barbershop.entity.*;
import com.example.barbershop.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class BarbershopApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BarbershopApplication.class, args);
        testAccount(applicationContext);
    }

    public static void testAccount(ApplicationContext applicationContext) {
        AccountService accountService = applicationContext.getBean(AccountService.class);
        MasterService masterService = applicationContext.getBean(MasterService.class);
        ProcedureService procedureService = applicationContext.getBean(ProcedureService.class);
        CommentService commentService = applicationContext.getBean(CommentService.class);
        RecordService recordService = applicationContext.getBean(RecordService.class);

        RecordEntity record = new RecordEntity();
        record.setClientId(6);
        record.setMasterId(5);
        record.setProcedureId(2);
        record.setRecordTime(new Date());
        record.setStatusId(1);
        record.setProcedureTimeRecord(new Date());

        System.out.println(recordService.findAllRecords());

//        CommentEntity comment = new CommentEntity();
//        comment.setRecordId(1);
//        comment.setCommentTime(new Date());
//        comment.setUserComment("norm voobshe");
//        comment.setRating(5);
//
//        System.out.println(1);
//        commentService.deleteCommentById(5);
//        System.out.println(2);



//        LevelEntity level = new LevelEntity();
//        level.setName("trainee");

//        MasterEntity master = MasterEntity.builder()
//                .email("test")
//                .password("test")
//                .roleId(2)
//                .phoneNumber("test")
//                .firstName("test")
//                .secondName("test")
//                .lastName("test")
//                .age(10)
//                .gender('ч')
//                .workExperience(10)
//                .levelId(1)
//                .rating(4)
//                .build();

//        accountService.addAccount(master);
//        accountService.deleteAccountById(29);
//        MasterEntity master = masterService.findMasterById(2);
//        System.out.println(master);
//        ProcedureEntity procedureEntity = procedureService.findProcedureEntityById(1);
//        System.out.println(procedureEntity);
//        masterService.addToMasterProcedure(master, procedureEntity);
//        masterService.deleteInMasterProcedure(master, procedureEntity);

    }

}
