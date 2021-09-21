package neuefische.shopservice.service;

import neuefische.shopservice.model.Order;
import neuefische.shopservice.model.Product;
import neuefische.shopservice.repo.OrderRepo;
import neuefische.shopservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    ProductRepo productRepo;
    OrderRepo orderRepo;

    @Autowired
    public ShopService(ProductRepo productRepo, OrderRepo orderRepo){
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public void addProducts(List<Product> products){
        productRepo.addProducts(products);
    }

    public void orderProducts(Order order){
        orderRepo.addOrder(order);
    }

    public List<Order> listAllOrders(){
        return orderRepo.listAllOrders();
    }

    public List<Product> listAllProducts(){
        return productRepo.listAllProducts();
    }
}
