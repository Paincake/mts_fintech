package ru.mts.thirdhw.serviceimpl;

import ru.mts.thirdhw.entity.Animal;
import ru.mts.thirdhw.entity.AnimalType;
import ru.mts.thirdhw.entity.Cat;
import ru.mts.thirdhw.entity.Crocodile;
import ru.mts.thirdhw.factory.SimpleAnimalFactory;
import ru.mts.thirdhw.service.CreateAnimalService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreateAnimalServiceImpl implements CreateAnimalService {
     public List<Animal> createAnimals(int n) {
         SimpleAnimalFactory simpleAnimalFactory = new SimpleAnimalFactory();
         List<Animal> animalList = new ArrayList<>();
         for(int i = 0; i < n; i++) {
             animalList.add(simpleAnimalFactory.createAnimal(AnimalType.CAT));
             animalList.add(simpleAnimalFactory.createAnimal(AnimalType.CROCODILE));
         }
         return animalList;
    }

    @Override
    public List<Animal> createAnimals() {
        SimpleAnimalFactory simpleAnimalFactory = new SimpleAnimalFactory();
        List<Animal> animalList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            animalList.add(simpleAnimalFactory.createAnimal(AnimalType.CAT));
            animalList.add(simpleAnimalFactory.createAnimal(AnimalType.CROCODILE));
        }
        return animalList;
    }
}
