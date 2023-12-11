package ru.mts;

public class Order {

    /*
    Класс Заказ - хранит информацию о заказе
    */

    // Количество товаров
    private int productCount;

    // Сумма товаров
    private double productSum;

    // Скидка на товар
    private double productDiscount;

    public Order() {
    }

    public Order(int productCount, double productSum, double productDiscount) {
        this.productCount = productCount;
        this.productSum = productSum;
        this.productDiscount = productDiscount;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public double getProductSum() {
        return productSum;
    }

    public void setProductSum(double productSum) {
        this.productSum = productSum;
    }

    public double getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }
}