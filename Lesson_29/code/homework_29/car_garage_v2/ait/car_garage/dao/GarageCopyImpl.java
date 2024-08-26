package homework_29.car_garage_v2.ait.car_garage.dao;
//Задание 1. Перенести код проекта Car-Garage в новый проект версии 2.0.
// Сделать рефакторинг проекта с использованием методов копирования класса
// Arrays по аналогии с проектом Employee-Company - см. код на занятии
// в пакете company_copy.

import homework_29.car_garage_v2.ait.car_garage.model.Car;

import java.util.Arrays;
import java.util.function.Predicate;

public class GarageCopyImpl implements Garage {

    private Car[] cars;
    private int size;

    public GarageCopyImpl(int capacity) {
        cars = new Car[capacity];
    }

    @Override
    public boolean addCar(Car car) {
        if (car == null || size == cars.length || findCarByRegNumber(car.getRegNumber()) != null) {
            return false;
        }
        cars[size++] = car;
        return true;

    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                Car temp = cars[i];
                cars[i] = cars[--size];
                return temp;
            }

        }
        return null;
    }


    @Override
    public Car findCarByRegNumber(String regNumber) {   // regNumber - который пришёл на сравнение
        for (int i = 0; i < size; i++) {  // бежим по массиву в рамках до правого края size до заполненного
            if (cars[i].getRegNumber().equals(regNumber)) { // если мы его найдём то мы его вернём которого мы найдём ->
                return cars[i];                             // он должен у нас совпасть regNumber сравнивание String!
                // потом вернём cars[i] которого нашёл и совпал
            }
        }
        return null;
    }

    @Override
    public Car[] findCarByModel(String model) {
        return findCarByPredicate(car -> model.equals(car.getModel()));
    }

    @Override
    public Car[] findCarByCompany(String company) {
        return findCarByPredicate(car -> company.equals(car.getCompany()));
    }

    @Override
    public Car[] findCarByEngine(double min, double max) {
        return findCarByPredicate(car -> car.getEngine() > min && car.getEngine() < max);
    }

    @Override
    public Car[] findCarByColor(String color) {
        return findCarByPredicate(car -> color.equals(car.getColor()));
    }

    private Car[] findCarByPredicate(Predicate<Car> predicate) {
        Car[] res = new Car[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(cars[i])) {
                res[j++] = cars[i];
            }
        }
        return Arrays.copyOf(res, j);
    }
    @Override
    public int quantityCar(){
        return size;
    }
}