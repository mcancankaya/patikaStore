package entity;

public class Notebook extends Product{
    private int memory;
    private int storage;
    private double screenSize;

    public Notebook(){
        super();
    }
    public Notebook( double unitPrice, double discountRate, int stockAmount, String name, Brand brand) {
        super( unitPrice, discountRate, stockAmount, name, brand);
    }
    public Notebook( double unitPrice, double discountRate, int stockAmount, String name, Brand brand, int memory, int storage, double screenSize) {
        super(unitPrice, discountRate, stockAmount, name, brand);
        this.memory = memory;
        this.storage = storage;
        this.screenSize = screenSize;
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
