package ru.mts.thirdhw.entity;

import java.math.BigDecimal;

public interface Animal {
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
