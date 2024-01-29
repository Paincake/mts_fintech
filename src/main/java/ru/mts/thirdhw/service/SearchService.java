package ru.mts.thirdhw.service;

import ru.mts.thirdhw.entity.Animal;

import java.util.List;

public interface SearchService {
    /**
     * Находит животных, которые родились в високосный год
     * @return Список имён животных
     * @param animalList Список животных
     * */
    List<String> findLeapYearNames(List<Animal> animalList);
    /**
     * Находит животных, которые старше чем lowerAge
     * @return Список животных
     * @param animalList Список животных
     * @param lowerAge Нижняя граница возраста
     * */
    List<Animal> findOlderAnimal(List<Animal> animalList, int lowerAge);
    /**
     * Находит дубликаты животных и возвращает список дубликатов
     * @param animalList Список животных
     * */
    List<Animal> findDuplicate(List<Animal> animalList);
    /**
     * Вызывает findDuplicate и выводит результат в стандартный поток
     * @param animalList Список животных
     * */
    void printDuplicate(List<Animal> animalList);
}
