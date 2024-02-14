package ru.mts.hwseven.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.mts.hwseven.entity.Animal;

import java.util.List;

@Component
public interface AnimalRepository {
    /**
     * Находит животных, которые родились в високосный год
     * @return Список имён животных
     * */
    List<String> findLeapYearNames();
    /**
     * Находит животных, которые старше чем lowerAge
     * @return Список животных

     * @param lowerAge Нижняя граница возраста
     * */
    List<Animal> findOlderAnimal(int lowerAge);
    /**
     * Находит дубликаты животных и возвращает список дубликатов

     * */
    List<Animal> findDuplicate();
    /**
     * Вызывает findDuplicate и выводит результат в стандартный поток
     * */
    void printDuplicate();
}
