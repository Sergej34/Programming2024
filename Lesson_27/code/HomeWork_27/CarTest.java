package HomeWork_27;

import homework_27.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class CarTest {

    homework_27.Car[] cars;

    @BeforeEach
    void setUp() {

        cars = new homework_27.Car[5];
        cars[0] = new homework_27.Car("BMW", "Blue", 25000, 2022);
        cars[1] = new homework_27.Car("Mercedes", "White", 35000, 2023);
        cars[2] = new homework_27.Car("VW", "Red", 20000, 2015);
        cars[3] = new homework_27.Car("Lexus", "Green", 22000, 2019);
        cars[4] = new homework_27.Car("Toyota", "Silver", 15000, 2018);
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
        Comparator<homework_27.Car> comparatorByPrice = new Comparator<homework_27.Car>() {
            @Override
            public int compare(homework_27.Car car1, homework_27.Car car2) {
                return (int) (car1.getPrice() - car2.getPrice());
            }
        };
        Arrays.sort(cars, comparatorByPrice);
        printArray(cars);
    }

    @Test
    void testSortByBrand() {
        printArray(cars);
        Comparator<homework_27.Car> comparatorByBrand = new Comparator<homework_27.Car>() {
            @Override
            public int compare(homework_27.Car car1, homework_27.Car car2) {
                return - car1.getBrand().compareTo(car2.getBrand());
            }
        };
        Arrays.sort(cars, comparatorByBrand);
        printArray(cars);
    }

    @Test
    void testSortByColor(){
        printArray(cars);
        Comparator<homework_27.Car> comparatorByColor = new Comparator<homework_27.Car>() {
            @Override
            public int compare(homework_27.Car car1, Car car2) {
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