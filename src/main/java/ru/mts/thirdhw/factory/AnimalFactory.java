package ru.mts.thirdhw.factory;

import ru.mts.thirdhw.entity.Animal;
import ru.mts.thirdhw.entity.AnimalType;

public interface AnimalFactory {
    Animal createAnimal(AnimalType animalType);
}
