package ru.mts.hwseven.factory;

import ru.mts.hwseven.entity.Animal;
import ru.mts.hwseven.entity.AnimalType;

public interface AnimalFactory {
    Animal createAnimal(AnimalType animalType);
}
