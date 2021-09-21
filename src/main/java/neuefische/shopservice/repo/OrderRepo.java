package neuefische.shopservice.repo;

import neuefische.shopservice.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepo {

    private Map<Integer, Order> orderRepo = new HashMap<>();

    public void addOrder(Order order){
        orderRepo.put(order.getId(), order);
    }

    public void removeOrder(int id){
        orderRepo.remove(id);
    }

    public List<Order> listAllOrders(){
        return new ArrayList<>(orderRepo.values());
    }
}
