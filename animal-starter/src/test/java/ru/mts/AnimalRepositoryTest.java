package ru.mts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.hwseven.entity.Animal;
import ru.mts.hwseven.entity.Cat;
import ru.mts.hwseven.entity.Crocodile;
import ru.mts.hwseven.repositoryimpl.AnimalRepositoryImpl;
import ru.mts.hwseven.serviceimpl.CreateAnimalServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest(classes = TestBeanConfig.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AnimalRepositoryTest {

    @MockBean
    AnimalRepositoryImpl animalRepository;
    @Autowired
    AnimalRepositoryImpl testAnimalRepository;
    @Autowired
    CreateAnimalServiceImpl createAnimalService;

    @DisplayName("Testing leap year names finding")
    @Test
    public void findLeapYearNames_shouldReturnEqualMap() {
        ConcurrentHashMap<String, LocalDate> givenMap = new ConcurrentHashMap<>();
        givenMap.put("TEST_NAME_ONE CAT", LocalDate.now());
        Mockito.when(animalRepository.findLeapYearNames()).thenReturn(givenMap);
        System.out.println("a");
    }

    @DisplayName("Testing finding older than N animals")
    @Test
    public void testFindOlderAnimals_shouldEqualGivenMap() {
        LocalDate oldBirthDate = LocalDate.now();
        ConcurrentHashMap<Animal, Integer> givenMap = new ConcurrentHashMap<>();
        givenMap.put(new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate), 3);
        Mockito.when(animalRepository.findOlderAnimal(0)).thenReturn(givenMap);
    }

    @DisplayName("Testing finding duplicates")
    @Test
    public void testFindDuplicate_shouldReturnGivenMap() {
        LocalDate oldBirthDate = LocalDate.now();
        ConcurrentHashMap<String, List<Animal>> animalMap = new ConcurrentHashMap<>();
        animalMap.put(
                "CAT", List.of(
                        new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate),
                        new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate),
                        new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate)
));
        Mockito.when(animalRepository.findDuplicate()).thenReturn(animalMap);
    }

    @DisplayName("Testing average age finding")
    @Test
    public void testFindAverageAge_shouldReturnGivenValue() {
        Mockito.when(animalRepository.findAverageAge()).thenReturn(BigDecimal.valueOf(10.0));
    }

    @DisplayName("Testing finding old and expensive animals")
    @Test
    public void testFindOldAndExpensive_shouldReturnEmptyList() {
        Mockito.when(animalRepository.findOldAndExpensive()).thenReturn(new CopyOnWriteArrayList<>());
    }

    @DisplayName("Testing finding min cost animals")
    @Test
    public void testFindMinCostAnimals_shouldReturnGivenList() {
        CopyOnWriteArrayList<String> givenList = new CopyOnWriteArrayList<>(List.of("TEST_NAME_ONE", "TEST_NAME_ONE", "TEST_NAME_ONE"));
        Mockito.when(animalRepository.findMinCostAnimals()).thenReturn(givenList);

    }


}
