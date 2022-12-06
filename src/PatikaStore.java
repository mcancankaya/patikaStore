import dataAccess.BrandDao;
import dataAccess.ProductDao;
import entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatikaStore {
    private BrandDao brandDao;
    private ProductDao productDao;
    private Scanner input = new Scanner(System.in);

    public PatikaStore() {
        brandDao = new BrandDao();
        productDao = new ProductDao();
        System.out.println(">>>>>> Store Hazırlanıyor");
        this.setTempProducts();
        System.out.println(">>>>>> Store Hazır");
    }

    public void setTempProducts(){
        MobilePhone mobilePhone1 = new MobilePhone(2500,5,12,"Mi9T",this.selectBrand("Xiaomi"),128,5.5,5000,6,"Mavi");
        MobilePhone mobilePhone2 = new MobilePhone(7500,5,3,"IPhone X",this.selectBrand("Apple"),256,7,5500,12,"Siyah");
        MobilePhone mobilePhone3 = new MobilePhone(2000,5,5,"Note 5",this.selectBrand("Samsung"),64,6,4400,8,"Kırmızı");
        MobilePhone mobilePhone4 = new MobilePhone(4000,5,7,"Note 9 Pro",this.selectBrand("Xiaomi"),128,7,5000,6,"Kırmızı");

        Notebook notebook1 = new Notebook(7500,2,4,"Lenovo G50-70",this.selectBrand("Lenovo"),16,512,15.6);
        Notebook notebook2 = new Notebook(15000,2,2,"Asus Rog xxx",this.selectBrand("Asus"),16,1024,15.6);
        Notebook notebook3 = new Notebook(19000,2,6,"Abra A5.xx",this.selectBrand("Monster"),32,512,17);
        Notebook notebook4 = new Notebook(5000,2,4,"Lenovo Ideapad",this.selectBrand("Lenovo"),8,256,15.6);

        Product[] arr = {mobilePhone1,mobilePhone2,mobilePhone3,mobilePhone4,notebook1,notebook2,notebook3,notebook4};

        for (Product m :arr) {
            this.productDao.addProduct(m);
        }
    }
    public void addBrand() {

        System.out.println("Marka adı gir : ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        Brand brand = new Brand(name);
        this.brandDao.addBrand(brand);

    }
    public void deleteBrand(){
        System.out.print("Marka Adı : ");
        String brand = input.next();
        this.brandDao.deleteBrand(brand);
    }

    public void addMobilePhone(){

        try{
            MobilePhone mobilePhone = new MobilePhone();
            System.out.print("Ürün Adı : ");
            String name = this.getInput();
            mobilePhone.setName(name);

            mobilePhone.setBrand(this.selectBrand());

            System.out.print("Fiyatı :  ");
            mobilePhone.setUnitPrice(Double.parseDouble(input.next()));

            System.out.print("İndirim Oranı : ");
            mobilePhone.setDiscountRate(Double.parseDouble(input.next()));

            System.out.print("Stok adeti : ");
            mobilePhone.setStockAmount(input.nextInt());

            System.out.print("Depolama : ");
            mobilePhone.setStorage(input.nextInt());

            System.out.print("Ekran : ");
            mobilePhone.setScreenSize(Double.parseDouble(input.next()));

            System.out.print("Ram : ");
            mobilePhone.setMemory(input.nextInt());

            System.out.print("Pil gücü : ");
            mobilePhone.setBatteryPower(input.nextInt());

            mobilePhone.setColor(this.selectColors());

            this.productDao.addProduct(mobilePhone);
        }catch(Exception e){
            System.out.println("Ürün Ekleme Sırasında Hata Oluştu !"+e.getMessage());
        }


    }
    public void deleteProductById(){
        System.out.print("Silmek istediğin ID ' i gir : ");
        int deleteId = input.nextInt();
        this.productDao.deleteProductById(deleteId);
    }

    public void addNotebook(){
        try {
            Notebook notebook = new Notebook();
            System.out.print("Ürün Adı : ");
            notebook.setName(this.getInput());

            while(notebook.getBrand()==null){
                Brand brand = this.selectBrand();
                notebook.setBrand(brand);
            }

            System.out.print("Fiyatı :  ");
            notebook.setUnitPrice(Double.parseDouble(input.next()));

            System.out.print("İndirim Oranı : ");
            notebook.setDiscountRate(Double.parseDouble(input.next()));

            System.out.print("Stok adeti : ");
            notebook.setStockAmount(input.nextInt());

            System.out.print("Depolama : ");
            notebook.setStorage(input.nextInt());

            System.out.print("Ekran : ");
            notebook.setScreenSize(Double.parseDouble(input.next()));

            System.out.print("Ram : ");
            notebook.setMemory(input.nextInt());

            this.productDao.addProduct(notebook);
        }catch (Exception e){
            System.out.println("Ürün Ekleme Sırasında Hata oluştu. "+e.getMessage());
        }

    }

    public String selectColors(){
        String[] colors = {"Siyah","Kırmızı","Mavi"};
        int select;
        for (int i = 0; i < colors.length; i++) {
            System.out.println(i+1 +" - "+colors[i]);
        }
        System.out.print("Renk Seçiniz : ");
        select= input.nextInt();

        return colors[select-1];
    }

    public Brand selectBrand() {
        getBrands();
        System.out.println("Marka Girin : ");
        String query="";
        while (query.isBlank()){
            query=this.input.nextLine();
        }
        Brand brand = brandDao.getFilterBrand(query);
        if (brand != null) {
            return brand;
        } else {
            System.out.println("Marka bulunamadı.");
        }
        return null;
    }
    public Brand selectBrand(String name) {

        Brand brand = brandDao.getFilterBrand(name);
        if (brand != null) {
            return brand;
        } else {
            System.out.println("Marka bulunamadı.");
        }
        return null;
    }
    public void getMobilePhoneList(){
        System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| ID | Ürün Adı                     | Fiyat       | İ. Oranı | Stok Adeti | Marka    | Renk     | Depolama | Ekran | RAM   | Pil Gücü |%n");
        System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------%n");
        for (MobilePhone mobilePhone : productDao.getMobilePhoneList()) {
                            //id, adı,      fiyat   i.oranı   stok   marka   renk    depo    ekran   ram     pil
        System.out.printf("| %-2d  | %-28s | %-11.2f | %8.2f | %-10d | %-8s | %-8s | %-8d | %-5.1f | %-5d | %-8d |%n",
                mobilePhone.getId(),
                mobilePhone.getName(),
                mobilePhone.getUnitPrice(),
                mobilePhone.getDiscountRate(),
                mobilePhone.getStockAmount(),
                mobilePhone.getBrand().getName(),
                mobilePhone.getColor(),
                mobilePhone.getStorage(),
                mobilePhone.getScreenSize(),
                mobilePhone.getMemory(),
                mobilePhone.getBatteryPower());
        }
        System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------%n");
    }
    public void getNotebookList() {
        System.out.printf("-----------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| ID | Ürün Adı                     | Fiyat       | İ. Oranı | Stok Adeti | Marka    | Depolama | Ekran | RAM   |%n");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------%n");
        for (Notebook notebook : productDao.getNotebookList()) {
            //
        System.out.printf("| %-2d  | %-28s | %-11.2f | %8.2f | %-10d | %-8s | %-8d | %-5.1f | %-5d |%n",
                            notebook.getId(),
                            notebook.getName(),
                            notebook.getUnitPrice(),
                            notebook.getDiscountRate(),
                            notebook.getStockAmount(),
                            notebook.getBrand().getName(),
                            notebook.getStorage(),
                            notebook.getScreenSize(),
                            notebook.getMemory());
        }
        System.out.printf("-----------------------------------------------------------------------------------------------------------------%n");
    }
    public String getInput(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String input = scanner.nextLine();
        return input;
    }
    public void getProductList(String brandFilter) {
        System.out.printf("--------------------------------------------------------------------------------------%n");
        System.out.printf("| ID | Ürün Adı                     | Fiyat       | İ. Oranı | Stok Adeti | Marka    |%n");
        System.out.printf("--------------------------------------------------------------------------------------%n");
        List<Product> products;
        if (brandFilter.isBlank()){
            products = productDao.getProducts();
        }else{
            products= productDao.getProductsByBrandName(brandFilter);
            if(products.size()<1){
                System.out.print("Aradığınız Markada Ürün Bulunmamaktadır.");
                return;
            }
        }
        for (Product product : products) {
            //
            System.out.printf("| %-2d | %-28s | %-11.2f | %8.2f | %-10d | %-8s |%n",
                    product.getId(),
                    product.getName(),
                    product.getUnitPrice(),
                    product.getDiscountRate(),
                    product.getStockAmount(),
                    product.getBrand().getName());
        }
        System.out.printf("--------------------------------------------------------------------------------------%n");
    }
    public void getBrands() {
        System.out.printf("------------------%n");
        System.out.printf("|    MARKALAR    |%n");
        System.out.printf("------------------%n");
        for (Brand brand : brandDao.getBrands()) {
            System.out.printf("| * | %-10s |%n", brand.getName());
        }
        System.out.printf("-------------------%n");
    }
    public void runStore() {
        boolean status=true,productStatus = true,brandStatus = true;
        int select;
        String welcomeScreen = "---Patika Store Yönetim Paneli---\n1. Ürün İşlemleri\n2. Marka İşlemleri\nSeçim : ";
        String productProcess = "-----  -----   Ürün İşlemleri  -----   -----\n0. Tüm ürünler\n1. Notebook Listele\n2. Telefonları Listele\n3. Markaya Göre Listele\n4. Telefon Ekle\n5. Notebook Ekle\n6. Ürün Sil\n7. Önceki Menü\nSeçim: ";
        String brandProcess = "-----  -----   Marka İşlemleri   -----   -----\n1. Marka Ekle\n2. Marka Sil\n3. Önceki Menü\nSeçim : ";
        while (status){
            System.out.print(welcomeScreen);
            select=input.nextInt();
            if (select ==1){
                productStatus=true;
                this.getProductList("");
                while(productStatus){

                    System.out.print(productProcess);
                    int process = input.nextInt();
                    switch (process){
                        case 0:
                            this.getProductList("");
                            break;
                        case 1:
                            this.getNotebookList();
                            break;
                        case 2:
                            this.getMobilePhoneList();
                            break;
                        case 3:
                            System.out.print("Marka Girin : ");
                            String brandName = input.next();
                            this.getProductList(brandName);
                            break;
                        case 4:
                            this.addMobilePhone();
                            break;
                        case 5:
                            this.addNotebook();
                            break;
                        case 6:
                            this.deleteProductById();
                            break;
                        case 7:
                            productStatus =false;
                            break;
                        default:
                            System.out.print("Hatalı Seçim !!!");
                    }
                }
            } else if (select==2) {
                brandStatus=true;
                while(brandStatus){
                    this.getBrands();
                    System.out.print(brandProcess);
                    int process =input.nextInt();
                    switch (process){
                        case 1:
                            this.addBrand();
                            break;
                        case 2:
                            this.deleteBrand();
                            break;
                        case 3:
                            brandStatus=false;
                        default:
                            System.out.println("Hatalı Seçim !!!");
                    }
                }

            }
        }

    }

}
