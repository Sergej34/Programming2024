package Classwork_35.city_bus;

import java.util.Objects;

public class Bus implements Comparable<Bus>{

    private String model;
    private String regNumber;
    private String routeNumber;
    private int busCapacity;

    public Bus(String model, String regNumber, String routeNumber, int busCapacity) {
        this.model = model;
        this.regNumber = regNumber;
        this.routeNumber = routeNumber;
        this.busCapacity = busCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public int getBusCapacity() {
        return busCapacity;
    }

    public void setBusCapacity(int busCapacity) {
        this.busCapacity = busCapacity;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Bus bus)) return false;
        return busCapacity == bus.busCapacity && Objects.equals(model, bus.model) && Objects.equals(regNumber, bus.regNumber) && Objects.equals(routeNumber, bus.routeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, regNumber, routeNumber, busCapacity);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bus{");
        sb.append("model='").append(model).append('\'');
        sb.append(", regNumber='").append(regNumber).append('\'');
        sb.append(", routeNumber='").append(routeNumber).append('\'');
        sb.append(", busCapacity=").append(busCapacity);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Bus o) {
        return - Integer.compare(this.busCapacity, o.busCapacity);
    }

}
