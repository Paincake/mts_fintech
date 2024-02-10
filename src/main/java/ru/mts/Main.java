package ru.mts;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mts.thirdhw.config.BeanConfig;
import ru.mts.thirdhw.repositoryimpl.AnimalRepositoryImpl;
import ru.mts.thirdhw.serviceimpl.CreateAnimalServiceImpl;


public class Main {
    public static void main(String[] args)  {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        context.register(BeanConfig.class);
        CreateAnimalServiceImpl createAnimalService = context.getBean(CreateAnimalServiceImpl.class);
        AnimalRepositoryImpl animalRepository = context.getBean(AnimalRepositoryImpl.class);
        animalRepository.printDuplicate();
        animalRepository.findOlderAnimal(10).forEach(System.out::println);
        animalRepository.findLeapYearNames().forEach(System.out::println);
    }
}