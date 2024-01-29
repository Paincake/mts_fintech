package ru.mts.thirdhw.serviceimpl;

import ru.mts.thirdhw.entity.Animal;
import ru.mts.thirdhw.service.SearchService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SearchServiceImpl implements SearchService {
    @Override
    public List<String> findLeapYearNames(List<Animal> animalList) {
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
    public List<Animal> findOlderAnimal(List<Animal> animalList, int lowerAge) {
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
    public List<Animal> findDuplicate(List<Animal> animalList) {
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
    public void printDuplicate(List<Animal> animalList) {
        List<Animal> duplicates = findDuplicate(animalList);
        for(Animal animal : duplicates) {
            System.out.println(animal);
        }
    }
}
