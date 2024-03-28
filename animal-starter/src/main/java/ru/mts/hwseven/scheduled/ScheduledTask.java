package ru.mts.hwseven.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.hwseven.entity.Animal;
import ru.mts.hwseven.exceptions.InvalidAgeException;
import ru.mts.hwseven.repository.AnimalRepository;

import javax.annotation.PostConstruct;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.*;

@Component
public class ScheduledTask {
    private AnimalRepository animalRepository;

    @PostConstruct
    public void schedule() {
        Runnable duplicatePrinterRunnable = () -> {
            Thread.currentThread().setName("printer_thread");
            System.out.println("PRINTING DUPLICATES");
            System.out.println(Thread.currentThread().getName());
            animalRepository.printDuplicate();
            System.out.println();
        };
        Runnable minimumCostRunnable = () -> {
            Thread.currentThread().setName("min_cost_thread");
            System.out.println("\nMinimum cost animals:");
            System.out.println(Thread.currentThread().getName());
            for(String name : animalRepository.findMinCostAnimals()) {
                System.out.println(name);
            }
            System.out.println();
        };
        ScheduledExecutorService duplicatePrinterPool = Executors.newScheduledThreadPool(1);
        duplicatePrinterPool.scheduleAtFixedRate(duplicatePrinterRunnable, 0, 10, TimeUnit.SECONDS);

        ScheduledExecutorService minimumCostPool = Executors.newScheduledThreadPool(1);
        minimumCostPool.scheduleWithFixedDelay(minimumCostRunnable, 0, 20, TimeUnit.SECONDS);
    }

    public ScheduledTask(@Autowired AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
    @Scheduled(fixedDelay = 60000)
    public void callAllMethods() {
        try {
            System.out.println("\nOlder animals:");
            for(Map.Entry<Animal, Integer> animalEntry : animalRepository.findOlderAnimal(10).entrySet()) {
                System.out.printf("%s %s ", animalEntry.getKey(), animalEntry.getValue());
                System.out.println();
            }
            System.out.println("\nLeap year names:");
            for(Map.Entry<String, LocalDate> animalEntry : animalRepository.findLeapYearNames().entrySet()) {
                System.out.printf("%s %s ", animalEntry.getKey(), animalEntry.getValue());
                System.out.println();
            }
            System.out.printf("\nAverage age:\n%f\n", animalRepository.findAverageAge());
            System.out.println("\nOld and expensive:");
            for(Animal animal : animalRepository.findOldAndExpensive()) {
                System.out.println(animal);
            }
        } catch (InvalidAgeException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
