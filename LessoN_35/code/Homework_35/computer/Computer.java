package Homework_35.computer;

import java.util.Objects;

//Задача 1. На основе класса Computer:
//создать собственный ArrayList;
//добавить в него не менее 6 элементов;
//отсортировать список по бренду;
//отсортировать список по размеру RAM, затем размеру SSD при равенстве RAM;
//подсчитать общий суммарный объем и среднее значение SSD.
public class Computer implements Comparable<Computer>{
    public static final int BARCODE_LENGTH = 15;

    private String cpu;
    private int ram;
    private int ssd;
    private String brand;
    private double price;
    private long barcode;

    public Computer(String cpu, int ram, int ssd, String brand, double price, long barcode) {
        this.cpu = cpu;
        this.ram = ram;
        this.ssd = ssd;
        this.brand = brand;
        this.price = price;
        this.barcode = checkBarCode(barcode);
    }
    private long checkBarCode(long barcode) {
        if (countDigits(barcode) == BARCODE_LENGTH) {
            return barcode;
        }
        return -1;

    }
    private int countDigits(long barcode) {
        int count = 0;
        do {
            count++;
            barcode = barcode / 10;
        } while (barcode != 0);
        return count;

    }

    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getSsd() {
        return ssd;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public long getBarcode() {
        return barcode;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Computer computer)) return false;
        return ram == computer.ram && ssd == computer.ssd && Double.compare(price, computer.price) == 0 && barcode == computer.barcode && Objects.equals(cpu, computer.cpu) && Objects.equals(brand, computer.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpu, ram, ssd, brand, price, barcode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Computer{");
        sb.append("cpu='").append(cpu).append('\'');
        sb.append(", ram=").append(ram);
        sb.append(", ssd=").append(ssd);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", price=").append(price);
        sb.append(", barcode=").append(barcode);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Computer o) {
        return this.brand.compareTo(o.brand);
    }
}
