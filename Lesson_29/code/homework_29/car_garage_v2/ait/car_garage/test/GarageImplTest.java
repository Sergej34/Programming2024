package homework_29.car_garage_v2.ait.car_garage.test;


import homework_29.car_garage_v2.ait.car_garage.dao.Garage;
import homework_29.car_garage_v2.ait.car_garage.dao.GarageCopyImpl;
import homework_29.car_garage_v2.ait.car_garage.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplTest {

    Garage garage;
    Car[] cars;

    @BeforeEach
    void setUp() {

        garage = new GarageCopyImpl(5);
        cars = new Car[4];
        cars[0] = new Car("Number1", "Model1", "Company1", 1.5, "Red");
        cars[1] = new Car("Number2", "Model2", "Company1", 2.5, "Green");
        cars[2] = new Car("Number3", "Model1", "Company2", 1.5, "Red");
        cars[3] = new Car("Number4", "Model4", "Company2", 2.0, "Green");

        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }

    }

    @Test
    void addCar() {
        assertFalse(garage.addCar(null));// добавление в гараж car null - не хотим видеть
        assertFalse(garage.addCar(cars[0]));// дубликат пробуем добавить cars[0] который уже есть
        Car car = new Car("Number5", "Model5", "Company3", 2.0, "White");
        assertTrue(garage.addCar(car));
        Car oneMoreCar = new Car("Number6", "ModelX", "CompanyXYZ", 2.0, "Grey");
        assertFalse(garage.addCar(oneMoreCar));
    }

    @Test
    void findCarByRegNumber() {
        Car car = garage.findCarByRegNumber("Number4");
        assertEquals(cars[3], garage.findCarByRegNumber("Number4"));
        assertEquals(cars[3], car);
        assertEquals(cars[3].getColor(), car.getColor());

    }

    @Test
    void findCarByModel() {
        Car[] expected = {cars[0], cars[2]};
        Car[] actual = garage.findCarByModel("Model1");
        assertArrayEquals(expected,actual);
    }

    @Test
    void findCarByCompany() {
        Car[] expected = {cars[0], cars[1]};
        Car[] actual = garage.findCarByCompany("Company1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarByEngine() {
        Car[] expected = {cars[1], cars[3]};
        Car[] actual = garage.findCarByEngine(1.9,2.6);
        assertArrayEquals(expected, actual);

    }

    @Test
    void findCarByColor() {
        Car[] expected = {cars[1], cars[3]};
        Car[] actual = garage.findCarByColor("Green");
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeCar() {
        Car carVictim = garage.removeCar("Number4");
        assertEquals(cars[3], carVictim);
        assertEquals(3,garage.quantityCar());
        assertNull(garage.removeCar("Number4"));

    }
}