package ru.mts.thirdhw.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Crocodile extends Predator {
    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal getCost() {
        return this.cost.setScale(2, RoundingMode.CEILING);
    }

    @Override
    public String getCharacter() {
        return this.character;
    }


    public Crocodile(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
    }


}
