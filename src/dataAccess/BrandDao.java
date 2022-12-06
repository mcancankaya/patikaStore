package dataAccess;

import entity.Brand;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BrandDao {
    private List<Brand> brands = null;

    private  void setBrandList(){
        brands = new ArrayList<>();
        this.brands.add(new Brand(1,"Samsung"));
        this.brands.add(new Brand(2,"Lenovo"));
        this.brands.add(new Brand(3,"Apple"));
        this.brands.add(new Brand(4,"Huawei"));
        this.brands.add(new Brand(5,"Casper"));
        this.brands.add(new Brand(6,"Asus"));
        this.brands.add(new Brand(7,"HP"));
        this.brands.add(new Brand(8,"Xiaomi"));
        this.brands.add(new Brand(9,"Monster"));
    }

    public BrandDao(){
        this.setBrandList();
    }

    public void addBrand(Brand brand){
        int id = this.brands.size()+1;
        brand.setId(id);
        this.brands.add(brand);
        System.out.println("Marka Eklendi. "+brand.getName());
    }
    public void deleteBrand(String brandName){
        Brand brand = this.brands.stream().filter(brand1 -> brand1.getName().equalsIgnoreCase(brandName)).findFirst().get();
        this.brands.remove(brand);
        System.out.println("Marka Silindi : "+brandName);
    }
    public List<Brand> getBrands(){
        List<Brand> brandsSortedList = this.brands.stream().sorted(Comparator.comparing(Brand::getName)).toList();
        return brandsSortedList;
    }
    public Brand getFilterBrand(String brandName){
        List<Brand> brands =  getBrands();
        Brand brand = brands.stream().filter(b-> b.getName().equalsIgnoreCase(brandName)).findFirst().get();
        return brand;
    }
}
