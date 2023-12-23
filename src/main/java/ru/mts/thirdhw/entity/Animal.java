package ru.mts.thirdhw.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Animal {
    /**
     * @return Дата рождения животного
     * */

    LocalDate getBirthDate();
    /**
     * @return Порода животного
     * */
    String getBreed();
    /**
     * @return Имя животного
     * */
    String getName();
    /**
     * @return Стоимость животного
     * */
    BigDecimal getCost();
    /**
     * @return Характер животного
     * */
    String getCharacter();

}
