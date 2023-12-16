package ru.mts;

import ru.mts.firsthw.Order;

import java.util.List;

public class Main {
    public static void printOrderSum(Order order) {
        System.out.printf(
                "Сумма без скидки: %f \nСумма со скидкой: %.2f \n\n",
                order.getProductSum(),
                order.getProductSum() * order.getProductDiscount()
        );
    }
    public static void main(String[] args) {
        Order firstOrder = new Order(10, 1412.191, 0.75);
        Order secondOrder = new Order(71, 53533.2222222222, 42.575);
        Order thirdOrder = new Order(3, 99.99, 59.1);
        List.of(firstOrder, secondOrder, thirdOrder).forEach(Main::printOrderSum);
    }
}