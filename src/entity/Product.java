package entity;

import java.util.*;
public abstract class Product {
    static HashSet<Brand> brands= new HashSet<>();
    static ArrayList<Product> products = new ArrayList<>();

    Scanner input = new Scanner(System.in);
    private static int id=1;
    private int categoryId;
    private double unitPrice;
    private double discountRate;
    private int stockAmount;
    private String name;
    private Brand brand;

    public Product(double unitPrice, double discountRate, int stockAmount, String name, Brand brand) {
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.name = name;
        this.brand = brand;
    }

    public abstract void menu();
    public abstract void add();
    public abstract void delete();
    public abstract void update();
    public abstract void getProducts();



    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getCategory() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId=categoryId;
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
