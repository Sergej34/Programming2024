package ait.computershop.model;
// Задача 2. В классной работе создать класс Smartphone, расширяющий класс Laptop с полем private long imei.
// В классе Smartphone переопределить метод toString. В методе main добавить объект Smartphone, и распечатать
// его в консоль.

import java.util.Objects;

public class SmartPhone extends Computer {
    private int cameraResolution;
    private long imei;


    public SmartPhone(long barcode, String cpu, int ram, int ssd, String brand, double price, int cameraResolution, long imei) {
        super(barcode, cpu, ram, ssd, brand, price);
        this.cameraResolution = cameraResolution;
        this.imei = imei;
    }

    public int getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(int cameraResolution) {
        this.cameraResolution = cameraResolution;
    }

    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }


}