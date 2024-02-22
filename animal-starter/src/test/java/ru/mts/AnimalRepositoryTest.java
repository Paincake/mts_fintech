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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.hwseven.entity.Animal;
import ru.mts.hwseven.entity.Cat;
import ru.mts.hwseven.entity.Crocodile;
import ru.mts.hwseven.repositoryimpl.AnimalRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest(classes = TestBeanConfig.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AnimalRepositoryTest {

    @MockBean
    AnimalRepositoryImpl animalRepository;

    @DisplayName("Testing leap year names finding")
    @Test
    public void findLeapYearNames_shouldReturnEqualList() {
        Mockito.when(animalRepository.findLeapYearNames()).thenReturn(List.of("TEST_NAME_ONE", "TEST_NAME_ONE", "TEST_NAME_ONE", "TEST_NAME_ONE","TEST_NAME_ONE","TEST_NAME_ONE","TEST_NAME_ONE","TEST_NAME_ONE","TEST_NAME_ONE","TEST_NAME_ONE"));
    }

    @DisplayName("Testing finding older than N animals")
    @Test
    public void testFindOlderAnimals_shouldEqualGivenList() {
        LocalDate oldBirthDate = LocalDate.now();
        List<Animal> givenList = List.of(
                new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate),
                new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate)
        );
        Mockito.when(animalRepository.findOlderAnimal(0)).thenReturn(givenList);
    }

    @Test
    public void testFindDuplicate_shouldReturnGivenList() {
        LocalDate oldBirthDate = LocalDate.now();
        List<Animal> duplicateList = List.of(
                new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate),
                new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate),
                new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate),
                new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate),
                new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate),
                new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate),
                new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate),
                new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate),
                new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate),
                new Cat("simple cat breed", "TEST_NAME_ONE", new BigDecimal("10"), "simple cat character", oldBirthDate)
        );
        Mockito.when(animalRepository.findDuplicate()).thenReturn(duplicateList);
    }

}
