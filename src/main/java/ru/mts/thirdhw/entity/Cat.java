package ru.mts.thirdhw.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cat extends Pet {

    @Override
    public String getBreed() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public BigDecimal getCost() {
        return this.cost.setScale(2, RoundingMode.CEILING);
    }

    @Override
    public String getCharacter() {
        return null;
    }

    public Cat(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
    }
}
