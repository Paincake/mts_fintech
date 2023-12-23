package ru.mts.thirdhw.factory;

import ru.mts.thirdhw.entity.Animal;
import ru.mts.thirdhw.entity.AnimalType;
import ru.mts.thirdhw.entity.Cat;
import ru.mts.thirdhw.entity.Crocodile;
import ru.mts.thirdhw.util.DateGenerator;

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
