package HomeWork_27;

import java.util.Objects;

//Задание 1. На примере класса Car с полями бренд, цвет, стоимость, год выпуска повторить все то,
//что делали с классом Wine на занятии.
//Задание 2(*). Напишите OddEvenComparator, реализующий Comparator с методом сравнения для сортировки
//массива целых чисел в следующем порядке: четные целые числа должны идти перед нечетными числами.
//Для проверки работы компаратора создайте обычный класс, в нем метод main, задайте в нем массив из 10
//случайных чисел в интервале от 1 до 100 и отсортируйте его с помощью OddEvenComparator.
//Пример: int[] array = {2, 5, 6, 10, 11, 18, 3}
//Результат после сортировки: {2, 6, 10, 18, 5, 11, 3}
public class Car implements Comparable<Car> {

    private String brand;
    private String color;
    private double price;
    private int year;

    public Car(String brand, String color, double price, int year) {
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Car car)) return false;
        return Double.compare(price, car.price) == 0 && year == car.year && Objects.equals(brand, car.brand) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, price, year);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", price=").append(price);
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();

    }

    @Override
    public int compareTo(Car car) {
        return - (this.getYear() - car.getYear());
    }
}
