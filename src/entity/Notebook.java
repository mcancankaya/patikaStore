package entity;

public class Notebook extends Product{
    private int memory;
    private int storage;
    private double screenSize;

    public Notebook( double unitPrice, double discountRate, int stockAmount, String name, Brand brand) {
        super( unitPrice, discountRate, stockAmount, name, brand);
    }
    public Notebook( double unitPrice, double discountRate, int stockAmount, String name, Brand brand, int memory, int storage, double screenSize) {
        super(unitPrice, discountRate, stockAmount, name, brand);
        this.memory = memory;
        this.storage = storage;
        this.screenSize = screenSize;
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
        int ram= input.nextInt();
        System.out.print("Ürünün ekranı : ");
        double screenSize= input.nextDouble();
        System.out.print("Ürünün hafızası :");
        int memory= input.nextInt();




    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void getProducts() {

    }


    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
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
}
