package homework_29.car_garage_v2.ait.car_garage.dao;


import homework_29.car_garage_v2.ait.car_garage.model.Car;

public interface Garage {

    boolean addCar(Car car);
    Car removeCar(String regNumber);
    Car findCarByRegNumber(String regNumber);
    Car[] findCarByModel(String model);
    Car[] findCarByCompany(String company);
    Car[] findCarByEngine(double min, double max);
    Car[] findCarByColor(String color);
    int quantityCar();
}
