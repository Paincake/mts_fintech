package ru.mts.thirdhw.service;

import ru.mts.thirdhw.entity.Animal;
import ru.mts.thirdhw.entity.Crocodile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface CreateAnimalService {
    default List<Animal> createAnimals() {
        List<Animal> animals = new ArrayList<>();
        int count = 1;
        while(animals.size() != 10) {
            Animal newAnimal = new Crocodile(
                    "breed " + count,
                    "Mister " + count,
                    new BigDecimal("123125124124.1231239999592191235215"),
                    "Character " + count
            );
            System.out.printf("Крокодил с именем %s, породой %s, стоимостью %s и характером %s создан\n",
                    newAnimal.getName(), newAnimal.getBreed(), newAnimal.getCost().toString(), newAnimal.getCharacter());
            animals.add(newAnimal);
            count++;
        }
        return animals;
    }
}
