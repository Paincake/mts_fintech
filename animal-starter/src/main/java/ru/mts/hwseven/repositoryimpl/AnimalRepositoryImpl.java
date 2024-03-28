package ru.mts.hwseven.repositoryimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.hwseven.entity.Animal;
import ru.mts.hwseven.exceptions.InvalidAgeException;
import ru.mts.hwseven.exceptions.NoEntityException;
import ru.mts.hwseven.repository.AnimalRepository;
import ru.mts.hwseven.serviceimpl.CreateAnimalServiceImpl;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;


@Component
public class AnimalRepositoryImpl implements AnimalRepository {
    private CopyOnWriteArrayList<Animal> animalList;

    @Autowired
    public AnimalRepositoryImpl(CreateAnimalServiceImpl createAnimalService) {
        this.createAnimalService = createAnimalService;
    }

    private CreateAnimalServiceImpl createAnimalService;
    @PostConstruct
    public void init(){
        animalList = new CopyOnWriteArrayList<>();
        animalList.addAll(createAnimalService.createAnimals(3));
    }
    @Override
    public ConcurrentHashMap<String, LocalDate> findLeapYearNames() {
        if(animalList == null) return new ConcurrentHashMap<>();
        ConcurrentHashMap<String, LocalDate> animalMap = new ConcurrentHashMap<>();
        animalList.stream()
                .filter(animal -> animal != null && animal.getBirthDate() != null && animal.getBirthDate().isLeapYear())
                .forEach(animal -> animalMap.put(animal.getName() + " " + createAnimalService.getAnimalType().name(), animal.getBirthDate()));
        return animalMap;
    }
    @Override
    public ConcurrentHashMap<Animal, Integer> findOlderAnimal(int lowerAge) {
        if (lowerAge < 0) {
            throw new InvalidAgeException("Invalid age: < 0");
        }
        if(animalList == null) return new ConcurrentHashMap<>();
        ConcurrentHashMap<Animal, Integer> animalMap = new ConcurrentHashMap<>();
        animalList.stream()
                .filter(animal -> animal != null && Math.abs(ChronoUnit.YEARS.between(LocalDate.now(), animal.getBirthDate())) > lowerAge)
                .forEach(animal -> animalMap.put(animal, (int)ChronoUnit.YEARS.between(LocalDate.now(), animal.getBirthDate())));
        return animalMap;
    }

    @Override
    public ConcurrentHashMap<String, List<Animal>> findDuplicate() {
        if(animalList == null) return null;
        return new ConcurrentHashMap<>(animalList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Animal::getName)));
    }

    @Override
    public BigDecimal findAverageAge() {
       double cost = animalList.stream()
               .mapToInt(animal -> Math.toIntExact(ChronoUnit.YEARS.between(LocalDate.now(), animal.getBirthDate())))
               .average().orElse(0.0);
       return new BigDecimal(cost);
    }

    @Override
    public CopyOnWriteArrayList<Animal> findOldAndExpensive() {
        return  animalList.stream()
                .filter(animal -> Math.toIntExact(ChronoUnit.YEARS.between(LocalDate.now(), animal.getBirthDate())) > 5 && animal.getCost().compareTo(findAverageAge()) > 0)
                .sorted(Comparator.comparing(Animal::getBirthDate))
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }

    @Override
    public CopyOnWriteArrayList<String> findMinCostAnimals() {
        try {
            if (animalList.isEmpty()) {
                throw new NoEntityException("findMinCostAnimals: empty animal list");
            }
        } catch (NoEntityException exc) {
            System.out.println(exc.getMessage());
        }
        return animalList.stream()
                .sorted()
                .limit(3)
                .map(Animal::getName)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }

    @Override
    public void printDuplicate() {
        Map<String, List<Animal>> duplicates = findDuplicate();
        for(Map.Entry<String, List<Animal>> duplicate : duplicates.entrySet()) {
            System.out.println(duplicate.getKey() + " " + duplicate.getValue());
        }
    }

    public CopyOnWriteArrayList<Animal> getAnimalList() {
        return animalList;
    }
}
