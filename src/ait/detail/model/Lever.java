package ait.detail.model;

import java.util.Objects;

public class Lever extends Detail{

    private double power;

    public Lever(long barCode, double size, String material, String vendor, double weight, double power) {
        super(barCode, size, material, vendor, weight);
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lever lever)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(power, lever.power) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), power);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lever{");
        sb.append("power=").append(power);
        sb.append('}');
        return sb.toString();
    }
}
