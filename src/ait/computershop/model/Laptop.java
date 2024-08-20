package ait.computershop.model;

import java.util.Objects;

public class Laptop extends Computer {
    private double displaySize;
    private double weight;
    private int batteryCapacity;


    public Laptop(long barcode, String cpu, int ram, int ssd, String brand, double price, double displaySize, double weight, int batteryCapacity) {
        super(barcode, cpu, ram, ssd, brand, price);
        this.displaySize = displaySize;
        this.weight = weight;
        this.batteryCapacity = batteryCapacity;
    }


    public double getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(double displaySize) {
        this.displaySize = displaySize;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }


}
