package entity;

import java.util.*;
public class Product {
    Scanner input = new Scanner(System.in);
    private  int id;
    private double unitPrice;
    private double discountRate;
    private int stockAmount;
    private String name;
    private Brand brand;

    public Product(){

    }
    public Product(double unitPrice, double discountRate, int stockAmount, String name, Brand brand) {
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.name = name;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
