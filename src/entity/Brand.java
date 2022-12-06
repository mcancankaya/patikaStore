package entity;

import java.util.ArrayList;

public class Brand {
    private  int id;
    private String name;

    public Brand(String name) {
        this.name = name;
    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
