package ru.mts.thirdhw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.thirdhw.service.CreateAnimalService;
import ru.mts.thirdhw.serviceimpl.CreateAnimalServiceImpl;

@Configuration
public class BeanConfig {
    @Bean
    @Scope("prototype")
    public CreateAnimalService getCreateAnimalServiceImpl() {
        return new CreateAnimalServiceImpl();
    }
}
