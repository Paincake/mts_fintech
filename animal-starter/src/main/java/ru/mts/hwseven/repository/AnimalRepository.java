package ru.mts.hwseven.repository;

import org.springframework.stereotype.Component;
import ru.mts.hwseven.entity.Animal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public interface AnimalRepository {
    /**
     * Находит животных, которые родились в високосный год
     *
     * @return Список имён животных
     */
    ConcurrentHashMap<String, LocalDate> findLeapYearNames();
    /**
     * Находит животных, которые старше чем lowerAge
     *
     * @param lowerAge Нижняя граница возраста
     * @return Список животных
     */
    ConcurrentHashMap<Animal, Integer> findOlderAnimal(int lowerAge);
    /**
     * Находит дубликаты животных и возвращает список дубликатов
     */
    ConcurrentHashMap<String, List<Animal>> findDuplicate();
    /**
     * Вызывает findDuplicate и выводит результат в стандартный поток
     * */
    BigDecimal findAverageAge();
    CopyOnWriteArrayList<Animal> findOldAndExpensive();
    CopyOnWriteArrayList<String> findMinCostAnimals();
    void printDuplicate();
}
