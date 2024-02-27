package ru.mts;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.hwseven.config.BeanConfig;
import ru.mts.hwseven.entity.Cat;
import ru.mts.hwseven.repositoryimpl.AnimalRepositoryImpl;

@SpringBootTest(classes = TestConfig.class)
@ActiveProfiles("test")
public class SpringBootApplicationTest {

    @Autowired
    private AnimalRepositoryImpl repository;

    @Test
    public void testContextLoad_ShouldLoadSuccessfully() {}

    @Test
    public void testContextLoad_BeanShouldLoad() {
        Assertions.assertNotNull(repository);
        Assertions.assertNotNull(repository.getAnimalList());
    }

    @Test
    public void testContextLoad_loadCatBean_ShouldThrowNoSuchBeanDefinition() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        context.register(BeanConfig.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean("cat"));
    }

    @Test
    public void testContextLoad_loadRepositoryBean_ShouldThrowNoSuchBeanDefinition() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        context.register(TestConfig.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean("animalRepositoryImpl"));
    }

}
