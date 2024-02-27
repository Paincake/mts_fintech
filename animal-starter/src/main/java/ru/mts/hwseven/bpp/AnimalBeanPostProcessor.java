package ru.mts.hwseven.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import ru.mts.hwseven.entity.Animal;
import ru.mts.hwseven.repositoryimpl.AnimalRepositoryImpl;

import java.util.Random;

@Configuration
public class AnimalBeanPostProcessor implements BeanPostProcessor {
    @Value("${animal.names}")
    private String[] animalNames;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("animalRepositoryImpl")) {
            AnimalRepositoryImpl repository = (AnimalRepositoryImpl) bean;
            for(Animal animal : repository.getAnimalList()) {
                animal.setName(animalNames[new Random().nextInt(animalNames.length)]);
            }
        }
        return bean;
    }
}
