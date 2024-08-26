package ait.minimarket.model;

import java.time.LocalDate;
import java.util.Objects;

public class MeatFood extends Product {

    private String meatType; // Тип мяса (говядина, свинина, курица и т.д.)
    private String origin;   // Страна происхождения

    public MeatFood(String barcode, String name, double price, String meatType, String origin) {
        super(barcode, name, price);
        this.meatType = meatType;
        this.origin = origin;
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


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MeatFood meatFood)) return false;
        if (!super.equals(object)) return false;
        return Objects.equals(meatType, meatFood.meatType) && Objects.equals(origin, meatFood.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), meatType, origin);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MeatFood{");
        sb.append("meatType='").append(meatType).append('\'');
        sb.append(", origin='").append(origin).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
