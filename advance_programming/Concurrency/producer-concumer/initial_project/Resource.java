import java.util.ArrayList;
import java.util.List;

public class Resource {
    private final List<Order> orders = new ArrayList<>();
    
    public void addNewOrder(Order order) {
        // TODO: Implement
    }
    
    public Order getNextOrder() throws InterruptedException {
        // TODO: Implement
    }
    
    public List<Order> getOrders() {
        return orders;
    }
}
