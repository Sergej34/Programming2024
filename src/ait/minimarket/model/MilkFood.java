package ait.minimarket.model;

import java.time.LocalDate;

public class MilkFood extends Product {

    private String milkType;    // Тип молочного продукта (Молоко, Йогурт, Сметана, Сыр и т.д.)
    private double fatContent;  // Содержание жира в процентах
    private double volume;      // Объем продукта в литрах

    public MilkFood(String barcode, String name, double price, String milkType,
                    double fatContent, double volume, LocalDate localDate, LocalDate expDate) {
        super(barcode, name, price, expDate);
        this.milkType = milkType;
        this.fatContent = fatContent;
        this.volume = volume;
    }

    public String getMilkType() {
        return milkType;
    }

    public void setMilkType(String milkType) {
        this.milkType = milkType;
    }

    public double getFatContent() {
        return fatContent;
    }

    public void setFatContent(double fatContent) {
        this.fatContent = fatContent;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
