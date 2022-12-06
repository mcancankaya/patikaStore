package dataAccess;

import entity.MobilePhone;
import entity.Notebook;
import entity.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private List<Product> products =  new ArrayList<>();;

    public ProductDao(){

    }


    public void addProduct(Product product){
        product.setId(products.size()+1);
        System.out.println("Eklendi : "+product.getName());
        this.products.add(product);
    }
    public void deleteProductById(int productId){
        try{
            this.products.remove(this.products.stream().filter(p-> p.getId()==productId).findFirst().get());
            System.out.println("Ürün Silindi : "+productId);
        }catch (Exception exception){
            System.out.println("Error : "+exception.getMessage());
        }

    }
    public List<Product> getProducts(){
        return this.products;
    }
    public List<Notebook> getNotebookList(){
        List<Notebook> notebookList=new ArrayList<>();
        for (Product p:this.products.stream().filter(product -> product.getClass()==Notebook.class).toList()) {
            notebookList.add((Notebook) p);
        }
        return notebookList;
    }
    public List<MobilePhone> getMobilePhoneList(){
        List<MobilePhone> mobilePhoneList = new ArrayList<>();
        for (Product p:this.products.stream().filter(product -> product.getClass()== MobilePhone.class).toList()) {
            mobilePhoneList.add((MobilePhone) p);
        }
        return mobilePhoneList;
    }
    public List<Product> getProductsByBrandName(String brandName){
        List<Product> productList=new ArrayList<>();
        for (Product p:this.products.stream().filter(product -> product.getBrand().getName().toLowerCase().contains(brandName.toLowerCase())).toList()) {
            productList.add(p);
        }
        return productList;
    }
}
