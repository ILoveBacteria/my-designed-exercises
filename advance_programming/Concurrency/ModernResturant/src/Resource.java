import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class Resource {
    private final List<Order> orders = new ArrayList<>();
    
    private Semaphore semaphore = new Semaphore(0);
    
    public synchronized void addNewOrder(Order order) {
        orders.add(order);
        semaphore.release();
    }
    
    public Order getNextOrder() throws InterruptedException {
        synchronized (orders) {
            semaphore.acquire();
            return orders.remove(0);
        }
    }
    
    public List<Order> getOrders() {
        return orders;
    }
}
