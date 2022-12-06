package entity;

import java.util.ArrayList;

public class MobilePhone extends Product {
    private int storage;
    private double screenSize;
    private int batteryPower;
    private int memory;
    private String color;

    public MobilePhone (){
        super();
    }
    public MobilePhone( double unitPrice, double discountRate, int stockAmount, String name, Brand brand) {
        super(unitPrice, discountRate, stockAmount, name, brand);
    }
    public MobilePhone(double unitPrice, double discountRate, int stockAmount, String name, Brand brand, int storage, double screenSize, int batteryPower, int memory, String color) {
        super(unitPrice, discountRate, stockAmount, name, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.memory = memory;
        this.color = color;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
            this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
