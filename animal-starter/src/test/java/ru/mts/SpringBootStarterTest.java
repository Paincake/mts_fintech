package ru.mts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;
import ru.mts.hwseven.config.BeanConfig;
import ru.mts.hwseven.entity.Animal;
import ru.mts.hwseven.entity.Cat;
import ru.mts.hwseven.entity.Crocodile;
import ru.mts.hwseven.repositoryimpl.AnimalRepositoryImpl;
import ru.mts.hwseven.serviceimpl.CreateAnimalServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


@SpringBootTest(classes = TestBeanConfig.class)
@ActiveProfiles("test")
public class SpringBootStarterTest {
    @Autowired
    private CreateAnimalServiceImpl animalService;
    @Autowired
    private AnimalRepositoryImpl animalRepository;

    @Test
    public void testContextLoad_ShouldLoadSuccessfully() {
        Assertions.assertNotNull(animalService);
        Assertions.assertNotNull(animalRepository.getAnimalList());
    }



}
