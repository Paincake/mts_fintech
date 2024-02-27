package ru.mts.hwseven.repositoryimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.mts.hwseven.entity.Animal;
import ru.mts.hwseven.repository.AnimalRepository;
import ru.mts.hwseven.serviceimpl.CreateAnimalServiceImpl;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


@Component
public class AnimalRepositoryImpl implements AnimalRepository {
    private List<Animal> animalList;

    @Autowired
    public AnimalRepositoryImpl(CreateAnimalServiceImpl createAnimalService) {
        this.createAnimalService = createAnimalService;
    }

    private CreateAnimalServiceImpl createAnimalService;
    @PostConstruct
    public void init(){
        animalList = new ArrayList<>();
        animalList.addAll(createAnimalService.createAnimals(3));
    }
    @Override
    public Map<String, LocalDate> findLeapYearNames() {
        if(animalList == null) return new HashMap<>();
        Map<String, LocalDate> animalMap = new HashMap<>();
        for(Animal animal : animalList) {
            if(
                    animal != null &&
                    animal.getBirthDate() != null &&
                    animal.getBirthDate().isLeapYear()
            ){
                animalMap.put(animal.getName() + " " + createAnimalService.getAnimalType().name(), animal.getBirthDate());
            }
        }
        return animalMap;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(int lowerAge) {
        if(animalList == null) return new HashMap<>();
        Map<Animal, Integer> animalMap = new HashMap<>();
        for(Animal animal : animalList) {
            if(animal == null) continue;
            long years = ChronoUnit.YEARS.between(LocalDate.now(), animal.getBirthDate());
            if(Math.abs(years) > lowerAge) {
                animalMap.put(animal, (int)years);
            }
        }
        return animalMap;
    }

    @Override
    public Map<String, Integer> findDuplicate() {
        if(animalList == null) return null;
        Map<String, Integer> animalMap = new HashMap<>();
        for(Animal animal : animalList) {
            animalMap.put(
                    createAnimalService.getAnimalType().name(),
                    animalMap.getOrDefault(createAnimalService.getAnimalType().name(), 0) + 1
            );
        }
        return animalMap;
    }

    @Override
    public void printDuplicate() {
        Map<String, Integer> duplicates = findDuplicate();
        for(Map.Entry<String, Integer> duplicate : duplicates.entrySet()) {
            System.out.println(duplicate.getKey() + " " + duplicate.getValue());
        }
    }

    @Scheduled(fixedDelay = 60000)
    public void callAllMethods() {
        printDuplicate();
        System.out.println("\nOlder animals:");
        for(Map.Entry<Animal, Integer> animalEntry : findOlderAnimal(10).entrySet()) {
            System.out.printf("%s %s ", animalEntry.getKey(), animalEntry.getValue());
            System.out.println();
        }
        System.out.println("\nLeap year names:");
        for(Map.Entry<String, LocalDate> animalEntry : findLeapYearNames().entrySet()) {
            System.out.printf("%s %s ", animalEntry.getKey(), animalEntry.getValue());
            System.out.println();
        }
    }


    public List<Animal> getAnimalList() {
        return animalList;
    }
}
