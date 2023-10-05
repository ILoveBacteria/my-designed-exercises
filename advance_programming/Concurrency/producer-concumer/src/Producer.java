public class Producer extends Thread {
    private final SafeResource safeResource;
    
    public Producer(SafeResource safeResource) {
        this.safeResource = safeResource;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            safeResource.addNewObject(i);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
