package ru.mts.thirdhw;

import ru.mts.thirdhw.serviceimpl.CreateAnimalServiceImpl;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl service = new CreateAnimalServiceImpl();
        service.createAnimals();
        service.createAnimals(100);
    }
}
