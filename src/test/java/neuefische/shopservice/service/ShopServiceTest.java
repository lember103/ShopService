package neuefische.shopservice.service;

import neuefische.shopservice.model.Order;
import neuefische.shopservice.model.Product;
import neuefische.shopservice.repo.OrderRepo;
import neuefische.shopservice.repo.ProductRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShopServiceTest {

    @Test
    void testAddProducts(){
        //GIVEN
        Product product = new Product(0, "apple");

        List<Product> products = new ArrayList<>();
        products.add(product);

        OrderRepo orderRepo = mock(OrderRepo.class);
        ProductRepo productRepo = mock(ProductRepo.class);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //WHEN
        shopService.addProducts(products);

        //THEN
        verify(productRepo).addProducts(products);
    }

    @Test
    void testorderProducts(){
        //GIVEN
        Product product = new Product(0, "apple");

        List<Product> products = new ArrayList<>();
        products.add(product);

        Order order = new Order(0, products);

        OrderRepo orderRepo = mock(OrderRepo.class);
        ProductRepo productRepo = mock(ProductRepo.class);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //WHEN
        shopService.orderProducts(order);

        //THEN
        verify(orderRepo).addOrder(order);
    }

    @Test
    void testListAllProducts(){
        //GIVEN
        List<Product> expected = new ArrayList<>();

        OrderRepo orderRepo = mock(OrderRepo.class);
        ProductRepo productRepo = mock(ProductRepo.class);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        when(productRepo.listAllProducts()).thenReturn(expected);

        //WHEN
        List<Product> actual = shopService.listAllProducts();

        //THEN
        assertEquals(expected, actual);
        verify(productRepo).listAllProducts();
    }

    @Test
    void testListAllOrders(){
        //GIVEN
        Product product0 = new Product(0, "apple");
        Product product1 = new Product(1, "banana");
        Product product2 = new Product(2, "pears");

        Order order0 = new Order(0, List.of(product0, product1));
        Order order1 = new Order(1, List.of(product0, product2));
        Order order2 = new Order(2, List.of(product1, product2));

        OrderRepo orderRepo = mock(OrderRepo.class);
        ProductRepo productRepo = mock(ProductRepo.class);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        List<Order> expected = List.of(order0, order1, order2);

        orderRepo.addOrder(order0);
        orderRepo.addOrder(order1);
        orderRepo.addOrder(order2);

        when(shopService.listAllOrders()).thenReturn(expected);

        //When
        List<Order> actual = shopService.listAllOrders();

        //THEN
        assertEquals(expected, actual);
    }

}