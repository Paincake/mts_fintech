package ru.mts.hwseven.repositoryimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.hwseven.entity.Animal;
import ru.mts.hwseven.repository.AnimalRepository;
import ru.mts.hwseven.serviceimpl.CreateAnimalServiceImpl;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;


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
        animalList.stream()
                .filter(animal -> animal != null && animal.getBirthDate() != null && animal.getBirthDate().isLeapYear())
                .forEach(animal -> animalMap.put(animal.getName() + " " + createAnimalService.getAnimalType().name(), animal.getBirthDate()));
        return animalMap;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(int lowerAge) {
        if(animalList == null) return new HashMap<>();
        Map<Animal, Integer> animalMap = new HashMap<>();
        animalList.stream()
                .filter(animal -> animal != null && Math.abs(ChronoUnit.YEARS.between(LocalDate.now(), animal.getBirthDate())) > lowerAge)
                .forEach(animal -> animalMap.put(animal, (int)ChronoUnit.YEARS.between(LocalDate.now(), animal.getBirthDate())));
        return animalMap;
    }

    @Override
    public Map<String, List<Animal>> findDuplicate() {
        if(animalList == null) return null;
        Map<String, Integer> animalMap = new HashMap<>();
        return animalList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Animal::getName));
    }

    @Override
    public BigDecimal findAverageAge() {
       double cost = animalList.stream()
               .mapToInt(animal -> Math.toIntExact(ChronoUnit.YEARS.between(LocalDate.now(), animal.getBirthDate())))
               .average().orElse(0.0);
       return new BigDecimal(cost);
    }

    @Override
    public List<Animal> findOldAndExpensive() {
        return animalList.stream()
                .filter(animal -> Math.toIntExact(ChronoUnit.YEARS.between(LocalDate.now(), animal.getBirthDate())) > 5 && animal.getCost().compareTo(findAverageAge()) > 0)
                .sorted(Comparator.comparing(Animal::getBirthDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findMinCostAnimals() {
        return animalList.stream()
                .sorted()
                .limit(3)
                .map(Animal::getName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    @Override
    public void printDuplicate() {
        Map<String, List<Animal>> duplicates = findDuplicate();
        for(Map.Entry<String, List<Animal>> duplicate : duplicates.entrySet()) {
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
