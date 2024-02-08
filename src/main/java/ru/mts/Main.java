package ru.mts;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.mts.firsthw.Order;
import ru.mts.thirdhw.config.BeanConfig;
import ru.mts.thirdhw.repositoryimpl.AnimalRepositoryImpl;
import ru.mts.thirdhw.serviceimpl.CreateAnimalServiceImpl;

import java.util.List;

@Configuration
@ComponentScan("C:\\Users\\Paincake-\\IdeaProjects\\mts_fintech\\src\\main\\java\\ru\\mts\\thirdhw")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        context.register(BeanConfig.class);
        CreateAnimalServiceImpl createAnimalService = context.getBean(CreateAnimalServiceImpl.class);
        AnimalRepositoryImpl animalRepository = context.getBean(AnimalRepositoryImpl.class);
        animalRepository.printDuplicate();
    }
}