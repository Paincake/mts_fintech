package ru.mts.hwseven.repository;

import org.springframework.stereotype.Component;
import ru.mts.hwseven.entity.Animal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
public interface AnimalRepository {
    /**
     * Находит животных, которые родились в високосный год
     * @return Список имён животных
     * */
    Map<String, LocalDate> findLeapYearNames();
    /**
     * Находит животных, которые старше чем lowerAge
     * @return Список животных

     * @param lowerAge Нижняя граница возраста
     * */
    Map<Animal, Integer> findOlderAnimal(int lowerAge);
    /**
     * Находит дубликаты животных и возвращает список дубликатов
     */
    Map<String, List<Animal>> findDuplicate();
    /**
     * Вызывает findDuplicate и выводит результат в стандартный поток
     * */
    BigDecimal findAverageAge();
    List<Animal> findOldAndExpensive();
    List<String> findMinCostAnimals();
    void printDuplicate();
}
