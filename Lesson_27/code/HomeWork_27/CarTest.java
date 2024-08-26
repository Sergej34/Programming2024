package HomeWork_27;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class CarTest {

    Car[] cars;

    @BeforeEach
    void setUp() {

        cars = new Car[5];
        cars[0] = new Car("BMW", "Blue", 25000, 2022);
        cars[1] = new Car("Mercedes", "White", 35000, 2023);
        cars[2] = new Car("VW", "Red", 20000, 2015);
        cars[3] = new Car("Lexus", "Green", 22000, 2019);
        cars[4] = new Car("Toyota", "Silver", 15000, 2018);
    }

    @Test
    void testSortCarByAge() {
        printArray(cars);
        Arrays.sort(cars);
        printArray(cars);
    }

    @Test
    void testSortByPrice() {
        printArray(cars);
        Comparator<Car> comparatorByPrice = new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return (int) (car1.getPrice() - car2.getPrice());
            }
        };
        Arrays.sort(cars, comparatorByPrice);
        printArray(cars);
    }

    @Test
    void testSortByBrand() {
        printArray(cars);
        Comparator<Car> comparatorByBrand = new Comparator<Car>() {
            @Override
            public int compare(Car car1,Car car2) {
                return - car1.getBrand().compareTo(car2.getBrand());
            }
        };
        Arrays.sort(cars, comparatorByBrand);
        printArray(cars);
    }

    @Test
    void testSortByColor(){
        printArray(cars);
        Comparator<Car> comparatorByColor = new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getColor().compareTo(car2.getColor());
            }
        };
        Arrays.sort(cars, comparatorByColor);
        printArray(cars);
    }

    // print array любых объектов
    public void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("-----------------------------------------");
    }
}