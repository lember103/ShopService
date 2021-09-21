package neuefische.shopservice.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private List<Product> products = new ArrayList<>();

    public Order(int id, List<Product> products){
        this.id = id;
        this.products = products;
    }

    public List<Product> getProducts(){
        return products;
    }

    public int getId(){
        return id;
    }
}
