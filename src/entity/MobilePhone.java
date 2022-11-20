package entity;

import java.util.ArrayList;

public class MobilePhone extends Product {
    private static  ArrayList<MobilePhone> mobilePhones = new ArrayList<>();
    private int storage;
    private double screenSize;
    private int batteryPower;
    private int memory;
    private String color;

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

    @Override
    public void menu() {

    }

    @Override
    public void add() {

        System.out.print("Ürünün fiyatı : ");
        double price= input.nextDouble();
        System.out.print("Ürünün adı : ");
        input.nextLine();
        String name=input.nextLine();
        System.out.print("Ürünün indirim oranı : ");
        int discountRate= input.nextInt();
        System.out.print("Ürünün stoğu : ");
        int amount= input.nextInt();
        System.out.print("Ürünün rami : ");
        int memory= input.nextInt();
        System.out.print("Ürünün ekranı : ");
        double screenSize= input.nextDouble();
        System.out.print("Ürünün hafızası :");
        int storage= input.nextInt();
        System.out.print("Ürünün pili : ");
        int battery= input.nextInt();
        input.nextLine();
        System.out.print("Ürünün rengi : ");
        String color= input.nextLine();




    }

    @Override
    public void delete() {
        getProducts();
    }

    @Override
    public void update() {

    }

    @Override
    public void getProducts() {

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
