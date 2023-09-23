public class Kitchen implements Runnable {
    private final Resource resource;
    
    public Kitchen(Resource resource) {
        this.resource = resource;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Order order = resource.getNextOrder();
                order.cookFood();
                foodIsReady(order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void foodIsReady(Order order) {
        synchronized (order) {
            order.notify();
        }
    }
}
