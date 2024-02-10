package ru.mts.thirdhw.repositoryimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.mts.thirdhw.entity.Animal;
import ru.mts.thirdhw.repository.AnimalRepository;
import ru.mts.thirdhw.serviceimpl.CreateAnimalServiceImpl;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Component

public class AnimalRepositoryImpl implements AnimalRepository {
    private List<Animal> animalList;
    @Autowired
    private CreateAnimalServiceImpl createAnimalService;
    @PostConstruct
    public void init(){
        animalList = new ArrayList<>();
        animalList.addAll(createAnimalService.createAnimals(10));
    }
    @Override
    public List<String> findLeapYearNames() {
        if(animalList == null) return new ArrayList<>();
        List<String> animalNamesList = new ArrayList<>();
        for(Animal animal : animalList) {
            if(
                    animal != null &&
                    animal.getBirthDate() != null &&
                    animal.getBirthDate().isLeapYear()
            ){
                animalNamesList.add(animal.getName());
            }
        }
        return animalNamesList;
    }

    @Override
    public List<Animal> findOlderAnimal(int lowerAge) {
        if(animalList == null) return new ArrayList<>();
        List<Animal> olderAnimalList = new ArrayList<>();
        for(Animal animal : animalList) {
            if(animal == null) continue;
            long years = ChronoUnit.YEARS.between(LocalDate.now(), animal.getBirthDate());
            if(Math.abs(years) > lowerAge) {
                olderAnimalList.add(animal);
            }
        }
        return olderAnimalList;
    }

    @Override
    public List<Animal> findDuplicate() {
        if(animalList == null) return null;
        Set<Animal> animalSet = new HashSet<>();
        List<Animal> duplicateList = new ArrayList<>();
        for(Animal animal : animalList) {
            if(animal != null && animalSet.contains(animal)) {
                duplicateList.add(animal);
            }
            else if(animal != null) {
                animalSet.add(animal);
            }
        }
        return duplicateList;
    }

    @Override
    public void printDuplicate() {
        List<Animal> duplicates = findDuplicate();
        for(Animal animal : duplicates) {
            System.out.println(animal);
        }
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
