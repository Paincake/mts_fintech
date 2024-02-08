package ru.mts.thirdhw.bpp;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import ru.mts.thirdhw.entity.AnimalType;

@Configuration
public class AnimalServiceBeanPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("createAnimalServiceImpl");
        beanDefinition.setAttribute("animalType", AnimalType.CAT);
    }
}
