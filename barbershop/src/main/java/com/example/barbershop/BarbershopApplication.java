package com.example.barbershop;

import com.example.barbershop.entity.*;
import com.example.barbershop.service.AccountService;
import com.example.barbershop.service.CommentService;
import com.example.barbershop.service.MasterService;
import com.example.barbershop.service.ProcedureService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BarbershopApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BarbershopApplication.class, args);
        testAccount(applicationContext);
//        testMaster(applicationContext);
    }

    public static void testMaster(ApplicationContext applicationContext) {
        MasterService masterService = applicationContext.getBean(MasterService.class);
        System.out.println(masterService.findAllMaster().size());

    }

    public static void testAccount(ApplicationContext applicationContext) {
        AccountService accountService = applicationContext.getBean(AccountService.class);
        MasterService masterService = applicationContext.getBean(MasterService.class);
        ProcedureService procedureService = applicationContext.getBean(ProcedureService.class);
        CommentService commentService = applicationContext.getBean(CommentService.class);

        System.out.println(commentService.findAllCommentsByProcedure(5));

        CommentEntity comment = new CommentEntity();
        comment.setRecordId(1);
        comment.setCommentTime(new Date());
        comment.setUserComment("norm voobshe");
        comment.setRating(5);

        System.out.println(1);
        commentService.deleteCommentById(5);
        System.out.println(2);



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
