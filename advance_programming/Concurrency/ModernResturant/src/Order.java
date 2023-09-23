import java.io.Serializable;

public class Order implements Serializable {
    private final int id;
    private final int cookTime;
    
    public Order(int id, int cookTime) {
        this.id = id;
        this.cookTime = cookTime;
    }
    
    public void cookFood() throws InterruptedException {
        Thread.sleep(cookTime);
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }
}
