public class Consumer extends Thread {
    private final SafeResource safeResource;
    
    public Consumer(SafeResource safeResource) {
        this.safeResource = safeResource;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(safeResource.getNextObject());
        }
    }
}
