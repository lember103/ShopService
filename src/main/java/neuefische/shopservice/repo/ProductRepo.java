package neuefische.shopservice.repo;

import neuefische.shopservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepo {

    private Map<Integer, Product> productRepo= new HashMap<>();

    public void addProduct(Product product){
        productRepo.put(product.getId(), product);
    }

    public void addProducts(List<Product> products){
        for (Product product : products) {
            addProduct(product);
        }
    }

    public void removeProduct(int id){
        productRepo.remove(id);
    }

    public List<Product> listAllProducts(){
        return new ArrayList<>(productRepo.values());
    }


}
