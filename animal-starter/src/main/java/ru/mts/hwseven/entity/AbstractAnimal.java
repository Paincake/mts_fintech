package ru.mts.hwseven.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class AbstractAnimal implements Animal {
    protected String breed;
    protected String name;
    protected BigDecimal cost;
    protected String character;
    protected LocalDate birthDate;

}
