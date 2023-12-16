package ru.mts.thirdhw.serviceimpl;

import ru.mts.thirdhw.entity.Animal;
import ru.mts.thirdhw.entity.Crocodile;
import ru.mts.thirdhw.service.CreateAnimalService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreateAnimalServiceImpl implements CreateAnimalService {
     public List<Animal> createAnimals(int n) {
        List<Animal> animals = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Animal newAnimal = new Crocodile(
                    "breed " + i,
                    "Mister " + i,
                    new BigDecimal("123125124124.1231239999592191235215"),
                    "Character " + i
            );
            System.out.printf("Крокодил с именем %s, породой %s, стоимостью %s и характером %s создан\n",
                    newAnimal.getName(), newAnimal.getBreed(), newAnimal.getCost().toString(), newAnimal.getCharacter());
            animals.add(newAnimal);
        }
        return animals;
    }

    @Override
    public List<Animal> createAnimals() {
        List<Animal> animals = new ArrayList<>();
        int count = 1;
        do {
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
        } while(count < 9);
        return animals;
    }
}
