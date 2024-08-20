package ait.minimarket.model;

public class MeatFood extends Product{

    private String meatType; // Тип мяса (говядина, свинина, курица и т.д.)
    private String origin;   // Страна происхождения
    private boolean isOrganic; // Органический продукт или нет

    public MeatFood(String barcode, String name, double price, String meatType, String origin, boolean isOrganic) {
        super(barcode, name, price);
        this.meatType = meatType;
        this.origin = origin;
        this.isOrganic = isOrganic;
    }

    public String getMeatType() {
        return meatType;
    }

    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean isOrganic() {
        return isOrganic;
    }

    public void setOrganic(boolean organic) {
        isOrganic = organic;
    }


}
