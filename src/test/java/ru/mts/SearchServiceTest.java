package ru.mts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mts.thirdhw.entity.Animal;
import ru.mts.thirdhw.entity.Cat;
import ru.mts.thirdhw.entity.Crocodile;
import ru.mts.thirdhw.serviceimpl.SearchServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @InjectMocks
    SearchServiceImpl searchService;

    @DisplayName("Testing leap year names finding")
    @Test
    public void findLeapYearNames_shouldReturnEqualList() {
        LocalDate leapYearDate = LocalDate.now();
        LocalDate nonLeapYearDate = LocalDate.of(2023, 12, 12);
        List<String> leapAnimalNameList = List.of("first leap cat", "second leap cat", "first leap crocodile", "second leap crocodile");
        List<Animal> nonLeapYearAnimalList = List.of(
                new Cat("a", "first leap cat", new BigDecimal("10"), "a", leapYearDate),
                new Cat("a", "second leap cat", new BigDecimal("10"), "a", leapYearDate),
                new Crocodile("a", "first leap crocodile", new BigDecimal("10"), "a", leapYearDate),
                new Crocodile("a", "second leap crocodile", new BigDecimal("10"), "a", leapYearDate),
                new Cat("a", "a", new BigDecimal("10"), "a", nonLeapYearDate),
                new Cat("a", "a", new BigDecimal("10"), "a", nonLeapYearDate),
                new Crocodile("a", "a", new BigDecimal("10"), "a", nonLeapYearDate),
                new Crocodile("a", "a", new BigDecimal("10"), "a", nonLeapYearDate)
        );

        Assertions.assertEquals(searchService.findLeapYearNames(nonLeapYearAnimalList), leapAnimalNameList);

    }

    @DisplayName("Testing finding older than N animals")
    @ParameterizedTest
    @MethodSource("testFindOlderAnimalsProvider")
    public void testFindOlderAnimals_shouldEqualGivenList(List<Animal> animalList) {
        LocalDate oldBirthDate = LocalDate.of(2012, 12, 12);
        List<Animal> givenList = List.of(
                new Cat("a", "a", new BigDecimal("10"), "a", oldBirthDate),
                new Cat("a", "a", new BigDecimal("10"), "a", oldBirthDate),
                new Crocodile("a", "a", new BigDecimal("10"), "a", oldBirthDate),
                new Crocodile("a", "a", new BigDecimal("10"), "a", oldBirthDate)
        );
        Assertions.assertEquals(searchService.findOlderAnimal(animalList, 10), givenList);
    }

    @Test
    public void testFindDuplicate_shouldReturnGivenList() {
        LocalDate oldBirthDate = LocalDate.of(2012, 12, 12);
        List<Animal> givenList = List.of(
                new Cat("a", "a", new BigDecimal("10"), "a", oldBirthDate),
                new Crocodile("a", "a", new BigDecimal("10"), "a", oldBirthDate)
        );
        List<Animal> duplicateList = List.of(
                new Cat("a", "a", new BigDecimal("10"), "a", oldBirthDate),
                new Cat("a", "a", new BigDecimal("10"), "a", oldBirthDate),
                new Crocodile("a", "a", new BigDecimal("10"), "a", oldBirthDate),
                new Crocodile("a", "a", new BigDecimal("10"), "a", oldBirthDate)
        );
        Assertions.assertEquals(searchService.findDuplicate(duplicateList), givenList);
    }

    public Stream<List<Animal>> testFindOlderAnimalsProvider() {
        LocalDate youngBirthDate = LocalDate.of(2023, 12, 12);
        LocalDate oldBirthDate = LocalDate.of(2012, 12, 12);
        return Stream.of(
                List.of(
                        new Cat("a", "first leap cat", new BigDecimal("10"), "a", youngBirthDate),
                        new Cat("a", "second leap cat", new BigDecimal("10"), "a", youngBirthDate),
                        new Crocodile("a", "first leap crocodile", new BigDecimal("10"), "a", youngBirthDate),
                        new Crocodile("a", "second leap crocodile", new BigDecimal("10"), "a", youngBirthDate),
                        new Cat("a", "a", new BigDecimal("10"), "a", oldBirthDate),
                        new Cat("a", "a", new BigDecimal("10"), "a", oldBirthDate),
                        new Crocodile("a", "a", new BigDecimal("10"), "a", oldBirthDate),
                        new Crocodile("a", "a", new BigDecimal("10"), "a", oldBirthDate)
                )
        );
    }
}
