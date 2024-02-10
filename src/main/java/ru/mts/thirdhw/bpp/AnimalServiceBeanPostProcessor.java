package ru.mts.thirdhw.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import ru.mts.thirdhw.entity.AnimalType;
import ru.mts.thirdhw.serviceimpl.CreateAnimalServiceImpl;

import java.util.Random;

@Configuration
public class AnimalServiceBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass() == CreateAnimalServiceImpl.class) {
            CreateAnimalServiceImpl animalService = (CreateAnimalServiceImpl) bean;
            AnimalType[] animalTypes = AnimalType.values();
            animalService.setAnimalType(animalTypes[new Random().nextInt(animalTypes.length)]);
        }
        return bean;
    }
}
