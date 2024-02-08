package ru.mts.thirdhw.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.mts.thirdhw.entity.Animal;
import ru.mts.thirdhw.entity.Cat;
import ru.mts.thirdhw.entity.Crocodile;
import ru.mts.thirdhw.util.DateGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
@Scope("prototype")
public interface CreateAnimalService {

    default List<Animal> createAnimals() {
        Random random = new Random();
        List<Animal> animals = new ArrayList<>();
        int count = 1;
        while(animals.size() != 10) {
            Animal newCroc = new Crocodile(
                    "breed " + count,
                    "Mister " + count,
                    new BigDecimal("123125124124.1231239999592191235215"),
                    "Character " + count,
                    DateGenerator.generateDate()
            );
            Animal newCat = new Cat(
                    "breed " + count,
                    "Miss " + count,
                    new BigDecimal("123125124124.1231239999592191235215"),
                    "Character " + count,
                    DateGenerator.generateDate()

            );

            System.out.printf("Крокодил с именем %s, породой %s, стоимостью %s и характером %s создан\n",
                    newCroc.getName(), newCroc.getBreed(), newCroc.getCost().toString(), newCroc.getCharacter());

            System.out.printf("Кошка с именем %s, породой %s, стоимостью %s и характером %s создан\n",
                    newCat.getName(), newCat.getBreed(), newCat.getCost().toString(), newCat.getCharacter());

            animals.add(newCroc);
            animals.add(newCat);
            count++;
        }
        return animals;
    }
}
