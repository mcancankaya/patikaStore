package entity;

import java.util.ArrayList;

public class Brand {
    private static ArrayList<Brand> brands = new ArrayList<Brand>();
    private static int id=1;
    private String name;

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public static void createBrands(){
        brands.add(new Brand(1,"Samsung"));
        brands.add(new Brand(2,"Lenovo"));
        brands.add(new Brand(3,"Apple"));
        brands.add(new Brand(4,"Huawei"));
        brands.add(new Brand(5,"Casper"));
        brands.add(new Brand(6,"Asus"));
        brands.add(new Brand(7,"HP"));
        brands.add(new Brand(8,"Xiaomi"));
        brands.add(new Brand(9,"Monster"));
    }

    public static void printBrands() {

        System.out.println("Marka Listesi ");
        for (Brand brand : brands) {
            System.out.println(brand.id + " " + brand.getName());
        }
        System.out.println("----------------------------");
    }

    public static Brand getBrand(int id){
        return null;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
