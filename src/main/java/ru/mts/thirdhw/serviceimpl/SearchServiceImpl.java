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
            if(years > lowerAge) {
                olderAnimalList.add(animal);
            }
        }
        return olderAnimalList;
    }

    @Override
    public void findDuplicate(List<Animal> animalList) {
        if(animalList == null) return;
        Set<Animal> animalSet = new HashSet<>();
        for(Animal animal : animalList) {
            if(animal != null && animalSet.contains(animal)) {
                System.out.println(animal.getName());
            }
            else if(animal != null) {
                animalSet.add(animal);
            }
        }
    }
}
