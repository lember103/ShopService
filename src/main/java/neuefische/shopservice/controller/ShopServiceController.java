package neuefische.shopservice.controller;

import neuefische.shopservice.model.Order;
import neuefische.shopservice.model.Product;
import neuefische.shopservice.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shop")
public class ShopServiceController {

    private ShopService shopService;

    @Autowired
    public ShopServiceController(ShopService shopService){
        this.shopService = shopService;
    }

    @GetMapping("allProducts")
    public List<Product> listAllProducts(){
        return shopService.listAllProducts();
    }

    @GetMapping("allOrders")
    public List<Order> listAllOrders(){
        return shopService.listAllOrders();
    }

    @PutMapping("addProducts")
    public void addProducts(@RequestBody List<Product> products){
        shopService.addProducts(products);
    }

    @PutMapping("orderProducts")
    public void orderProducts(@RequestBody Order order){
        shopService.orderProducts(order);
    }
}
