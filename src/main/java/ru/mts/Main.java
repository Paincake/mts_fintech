package ru.mts;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.mts.hwseven.config.BeanConfig;
import ru.mts.hwseven.repositoryimpl.AnimalRepositoryImpl;
import ru.mts.hwseven.serviceimpl.CreateAnimalServiceImpl;


@SpringBootApplication
@EnableScheduling
public class Main {
    public static void main(String[] args)  {
        SpringApplication.run(Main.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        context.register(BeanConfig.class);
        CreateAnimalServiceImpl createAnimalService = context.getBean(CreateAnimalServiceImpl.class);
        AnimalRepositoryImpl animalRepository = context.getBean(AnimalRepositoryImpl.class);
        animalRepository.callAllMethods();
    }
}