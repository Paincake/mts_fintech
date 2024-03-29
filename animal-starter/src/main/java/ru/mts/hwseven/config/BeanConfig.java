package ru.mts.hwseven.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.hwseven.service.CreateAnimalService;
import ru.mts.hwseven.serviceimpl.CreateAnimalServiceImpl;

@Configuration
@ComponentScan("ru.mts")
public class BeanConfig {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CreateAnimalService getCreateAnimalServiceImpl() {
        return new CreateAnimalServiceImpl();
    }
}
