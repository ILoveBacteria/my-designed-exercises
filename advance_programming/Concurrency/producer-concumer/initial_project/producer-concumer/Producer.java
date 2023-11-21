public class Producer extends Thread {
    private final SafeResource safeResource;
    
    public Producer(SafeResource safeResource) {
        this.safeResource = safeResource;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            safeResource.addNewObject(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
