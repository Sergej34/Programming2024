package ait.computershop.model;

import java.util.Objects;

// Создать класс Computer c полями:
//- cpu
//- ram
//- ssd
//- brand
//- price
public abstract class Computer {
    // field
    protected long barcode;
    protected String cpu;
    protected int ram;
    protected int ssd;
    protected String brand;
    protected double price;

    // constructor


    public Computer(long barcode, String cpu, int ram, int ssd, String brand, double price) {
        this.barcode = barcode;
        this.cpu = cpu;
        this.ram = ram;
        this.ssd = ssd;
        this.brand = brand;
        this.price = price;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Computer computer)) return false;
        return Objects.equals(barcode,computer.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(barcode);
    }

/*@Override
    public String toString() {
        return "Computer| " + "CPU - " + cpu + ", RAM - " + ram + ", SSD - " + ssd + ", BRAND - " + brand  + ", PRICE - " + price + "€ ";*/

    @Override
    public String toString() {
        return "Computer{" +
                "barcode=" + barcode +
                ", cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", ssd=" + ssd +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
