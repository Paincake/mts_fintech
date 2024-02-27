package ru.mts.hwseven.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import ru.mts.hwseven.entity.AnimalType;
import ru.mts.hwseven.serviceimpl.CreateAnimalServiceImpl;

import java.util.Random;

@Configuration
public class AnimalServiceBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass() == CreateAnimalServiceImpl.class) {

            CreateAnimalServiceImpl animalService = (CreateAnimalServiceImpl) bean;
            AnimalType[] animalTypes = AnimalType.values();
            AnimalType type = animalTypes[new Random().nextInt(animalTypes.length)];
            animalService.setAnimalType(type);
        }
        return bean;
    }
}
