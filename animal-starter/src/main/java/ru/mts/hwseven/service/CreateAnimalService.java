package ru.mts.hwseven.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.mts.hwseven.entity.Animal;
import ru.mts.hwseven.entity.AnimalType;
import ru.mts.hwseven.entity.Cat;
import ru.mts.hwseven.entity.Crocodile;
import ru.mts.hwseven.util.DateGenerator;

import java.math.BigDecimal;
import java.util.*;

@Component
@Scope("prototype")
public interface CreateAnimalService {

    default Map<String, List<Animal>> createAnimals() {
        Random random = new Random();
        Map<String, List<Animal>> animals = new HashMap<>();
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

            animals.putIfAbsent(AnimalType.CROCODILE.name(), new ArrayList<>());
            animals.get(AnimalType.CROCODILE.name()).add(newCroc);
            animals.putIfAbsent(AnimalType.CAT.name(), new ArrayList<>());
            animals.get(AnimalType.CAT.name()).add(newCat);
            count++;
        }
        return animals;
    }
}
