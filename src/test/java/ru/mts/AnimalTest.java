package ru.mts;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.mts.thirdhw.entity.Animal;
import ru.mts.thirdhw.entity.Cat;
import ru.mts.thirdhw.entity.Crocodile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AnimalTest {

    @DisplayName("Equals returning true")
    @ParameterizedTest
    @MethodSource("testEqualsTrueProvider")
    public  void testEquals_shouldReturnTrue(Map<Animal, Animal> animalMap) {
        for(Map.Entry<Animal, Animal> entry : animalMap.entrySet()) {
            Assertions.assertEquals(entry.getKey(), entry.getValue());
        }
    }

    @DisplayName("Equals returning false")
    @ParameterizedTest
    @MethodSource("testEqualsFalseProvider")
    public void testEquals_shouldReturnFalse(Map<Animal, Animal> animalMap) {
        for(Map.Entry<Animal, Animal> entry : animalMap.entrySet()) {
            Assertions.assertNotEquals(entry.getKey(), entry.getValue());
        }
    }

    @DisplayName("Testing collision in hashmap")
    @Test
    public void testEqualsAndHashcodeInMap_shouldReturnTrue() {
        LocalDate birthDate = LocalDate.now();
        Cat firstPairKey = new Cat("a", "a", new BigDecimal("10"), "a", birthDate);
        Cat firstPairValue = new Cat("a", "a", new BigDecimal("10"), "a", birthDate);
        Cat secondPairKey = new Cat("a", "a", new BigDecimal("10"), "a", birthDate);
        Cat secondPairValue = new Cat("a", "a", new BigDecimal("100"), "b", birthDate);

        Map<Animal, Animal> animalMap = new HashMap<>();
        animalMap.put(firstPairKey, firstPairValue);
        animalMap.put(secondPairKey, secondPairValue);

        Assertions.assertEquals(animalMap.get(firstPairKey), animalMap.get(secondPairKey));

    }

    public static Stream<Map<Animal, Animal>> testEqualsTrueProvider() {
        LocalDate birthDate = LocalDate.now();
        Cat firstCat = new Cat("a", "a", new BigDecimal("10"), "a", birthDate);
        Cat secondCat = new Cat("a", "a", new BigDecimal("10"), "a", birthDate);

        Crocodile firstCrocodile = new Crocodile("a", "a", new BigDecimal("10"), "a", birthDate);
        Crocodile secondCrocodile = new Crocodile("a", "a", new BigDecimal("10"), "a", birthDate);

        return Stream.of(Map.of(
                firstCat, secondCat,
                firstCrocodile, secondCrocodile)
        );
    }

    public static Stream<Map<Animal, Animal>> testEqualsFalseProvider() {
        LocalDate birthDate = LocalDate.now();
        Cat firstCat = new Cat("a", "aa", new BigDecimal("11"), "b", birthDate);
        Cat secondCat = new Cat("a", "a", new BigDecimal("10"), "a", birthDate);

        Crocodile firstCrocodile = new Crocodile("c", "a", new BigDecimal("12222"), "hehe", birthDate);
        Crocodile secondCrocodile = new Crocodile("a", "a", new BigDecimal("10"), "a", birthDate);

        return Stream.of(Map.of(
                firstCat, secondCat,
                firstCrocodile, secondCrocodile)
        );
    }


}
