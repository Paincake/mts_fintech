package ru.mts.thirdhw.serviceimpl;

import ru.mts.thirdhw.entity.Animal;
import ru.mts.thirdhw.entity.Cat;
import ru.mts.thirdhw.entity.Crocodile;
import ru.mts.thirdhw.service.CreateAnimalService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreateAnimalServiceImpl implements CreateAnimalService {
     public List<Animal> createAnimals(int n) {
        List<Animal> animals = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Animal newCroc = new Crocodile(
                    "breed " + i,
                    "Mister " + i,
                    new BigDecimal("123125124124.1231239999592191235215"),
                    "Character " + i
            );
            Animal newCat = new Cat(
                    "breed " + i,
                    "Miss " + i,
                    new BigDecimal("123125124124.1231239999592191235215"),
                    "Character " + i
            );

            System.out.printf("Крокодил с именем %s, породой %s, стоимостью %s и характером %s создан\n",
                    newCroc.getName(), newCroc.getBreed(), newCroc.getCost().toString(), newCroc.getCharacter());

            System.out.printf("Кошка с именем %s, породой %s, стоимостью %s и характером %s создан\n",
                    newCat.getName(), newCat.getBreed(), newCat.getCost().toString(), newCat.getCharacter());

            animals.add(newCroc);
            animals.add(newCat);
        }
        return animals;
    }

    @Override
    public List<Animal> createAnimals() {
        List<Animal> animals = new ArrayList<>();
        int count = 1;
        do {
            Animal newCroc = new Crocodile(
                    "breed " + count,
                    "Mister " + count,
                    new BigDecimal("123125124124.1231239999592191235215"),
                    "Character " + count
            );
            Animal newCat = new Cat(
                    "breed " + count,
                    "Miss " + count,
                    new BigDecimal("123125124124.1231239999592191235215"),
                    "Character " + count
            );

            System.out.printf("Крокодил с именем %s, породой %s, стоимостью %s и характером %s создан\n",
                    newCroc.getName(), newCroc.getBreed(), newCroc.getCost().toString(), newCroc.getCharacter());

            System.out.printf("Кошка с именем %s, породой %s, стоимостью %s и характером %s создан\n",
                    newCat.getName(), newCat.getBreed(), newCat.getCost().toString(), newCat.getCharacter());

            animals.add(newCroc);
            animals.add(newCat);
            count += 2;
        } while(count < 9);
        return animals;
    }
}
