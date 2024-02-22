package ru.mts;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.mts.hwseven.entity.Animal;
import ru.mts.hwseven.entity.AnimalType;
import ru.mts.hwseven.repositoryimpl.AnimalRepositoryImpl;
import ru.mts.hwseven.serviceimpl.CreateAnimalServiceImpl;

import java.util.Random;


@TestConfiguration
@SpringBootConfiguration
@ActiveProfiles("test")
public class TestBeanConfig implements BeanPostProcessor {

    private final String[] animalNames;

    @Autowired
    public TestBeanConfig(@Value("${animal.names}")String[] animalNames) {
        this.animalNames = animalNames;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("testAnimalRepositoryImpl")) {
            AnimalRepositoryImpl repository = (AnimalRepositoryImpl) bean;
            for(Animal animal : repository.getAnimalList()) {
                animal.setName(animalNames[new Random().nextInt(animalNames.length)]);
            }
        }
        return bean;
    }
    @Bean
    CreateAnimalServiceImpl testAnimalServiceImpl() {
        CreateAnimalServiceImpl animalService = new CreateAnimalServiceImpl();
        animalService.setAnimalType(AnimalType.CAT);
        return animalService;
    }

    @Bean
    AnimalRepositoryImpl testAnimalRepositoryImpl() {
        return new AnimalRepositoryImpl(testAnimalServiceImpl());
    }

}
