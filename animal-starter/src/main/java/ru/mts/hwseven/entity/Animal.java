package ru.mts.hwseven.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Animal {
    /**
     * @return animal's birthdate
     * */

    LocalDate getBirthDate();
    /**
     * @return animal's breed
     * */
    String getBreed();
    /**
     * @return animal's name
     * */
    String getName();
    /**
     * @return animal's cost
     * */
    BigDecimal getCost();
    /**
     * @return animal's character
     * */
    String getCharacter();
    void setName(String name);

}
