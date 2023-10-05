public class Consumer extends Thread {
    private final SafeResource safeResource;
    
    public Consumer(SafeResource safeResource) {
        this.safeResource = safeResource;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(safeResource.getNextObject());
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
