package ru.mts.hwseven.factory;

import ru.mts.hwseven.entity.Animal;
import ru.mts.hwseven.entity.AnimalType;
import ru.mts.hwseven.entity.Cat;
import ru.mts.hwseven.entity.Crocodile;
import ru.mts.hwseven.util.DateGenerator;

import java.math.BigDecimal;

public class SimpleAnimalFactory implements AnimalFactory {
    @Override
    public Animal createAnimal(AnimalType animalType) {
        switch (animalType) {
            case CAT:
                return new Cat(
                        "simple cat breed",
                        "simple cat name",
                        BigDecimal.valueOf(10.0),
                        "simple cat character",
                        DateGenerator.generateDate());
            case CROCODILE:
                return new Crocodile(
                        "simple croc breed",
                        "simple croc name",
                        BigDecimal.valueOf(10.0),
                        "simple croc character",
                        DateGenerator.generateDate());
            default:
                return null;
        }
    }
}
