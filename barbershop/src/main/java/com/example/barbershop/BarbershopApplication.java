package com.example.barbershop;

import com.example.barbershop.entities.Animal;
import com.example.barbershop.entities.GiraffeEntity;
import com.example.barbershop.entities.WolfEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class BarbershopApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BarbershopApplication.class, args);


        AnimalService animalService = applicationContext.getBean(AnimalService.class);
//        System.out.println("save giraffe");
//        GiraffeEntity giraffe = GiraffeEntity.builder()
//                .height(3.5f)
//                .cageNumber("10-a")
//                .name("My first giraffe")
//                .build();
//        giraffe = animalService.saveNewAnimal(giraffe);
//        System.out.println("New giraffe: " + giraffe);
//
//        System.out.println("save wolf");
//        WolfEntity wolf = WolfEntity.builder()
//                .liveRegion("Siberia")
//                .cageNumber("20-5")
//                .name("Siberia wolf 1")
//                .build();
//        wolf = animalService.saveNewAnimal(wolf);
//        System.out.println("New wolf: " + wolf);
//
//        List<Animal> myZooAnimals = List.of(
//                animalService.getAnimalById(1, GiraffeEntity.class),
//                animalService.getAnimalById(2, WolfEntity.class)
//        );
//
//        System.out.println("My animals: " + myZooAnimals);

        System.out.println("Get all animals: " + animalService.getAllAnimals());


        accountExam(applicationContext);
    }

    public static void accountExam(ApplicationContext applicationContext) {

//        MasterService masterService = applicationContext.getBean(MasterService.class);
//        System.out.println(masterService.findAllMaster());


//        // good
//        LevelService levelService = applicationContext.getBean(LevelService.class);
//        System.out.println(levelService.findAllLevel());

//        // good
//        AccountService accountService = applicationContext.getBean(AccountService.class);
//        System.out.println(accountService.findAccountById(1));
//        System.out.println(accountService.findAllAccounts());
//        System.out.println(accountService.findAllMasterByRole());

//        // good
//        RoleService roleService = applicationContext.getBean(RoleService.class);
//        System.out.println(roleService.findAllRoles());

    }
}
