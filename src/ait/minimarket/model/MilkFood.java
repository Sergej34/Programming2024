package ait.minimarket.model;

public class MilkFood extends Product {

    private String milkType;    // Тип молочного продукта (Молоко, Йогурт, Сметана, Сыр и т.д.)
    private double fatContent;  // Содержание жира в процентах
    private double volume;      // Объем продукта в литрах

    public MilkFood(String barcode, String name, double price, String milkType, double fatContent, double volume) {
        super(barcode, name, price);
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
