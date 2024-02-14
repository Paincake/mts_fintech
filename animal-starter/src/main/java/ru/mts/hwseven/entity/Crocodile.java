package ru.mts.hwseven.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Crocodile extends Predator {
    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }
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

    @Override
    public void setName(String name) {
        this.name = name;
    }


    public Crocodile(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }
    @Override
    public int hashCode(){
        final int prime = 201;
        int result = 133;
        return result * breed.hashCode() + name.hashCode() * birthDate.hashCode() * character.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        };
        Crocodile other = (Crocodile) obj;
        return breed.equals(other.breed) &&
                name.equals(other.name) &&
                cost.equals(other.cost) &&
                character.equals(other.character) &&
                birthDate.equals(other.birthDate);

    }


}
