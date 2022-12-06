import dataAccess.BrandDao;
import dataAccess.ProductDao;
import entity.Brand;
import entity.MobilePhone;
import entity.Notebook;
import entity.Product;

public class Main {
    public static void main(String[] args){
        PatikaStore patikaStore = new PatikaStore();
        patikaStore.runStore();

    }
}