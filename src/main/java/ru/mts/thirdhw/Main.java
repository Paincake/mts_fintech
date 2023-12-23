package ru.mts.thirdhw;

import ru.mts.thirdhw.serviceimpl.CreateAnimalServiceImpl;
import ru.mts.thirdhw.serviceimpl.SearchServiceImpl;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl creationService = new CreateAnimalServiceImpl();
        SearchServiceImpl searchService = new SearchServiceImpl();
        searchService.findDuplicate(creationService.createAnimals(5));
        searchService.findLeapYearNames(creationService.createAnimals());
        searchService.findOlderAnimal(creationService.createAnimals(10), 4);
    }
}
