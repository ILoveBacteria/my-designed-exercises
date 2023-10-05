import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SafeResource {
    private final List<Object> objectList = new ArrayList<>();
    
    private final Semaphore semaphore = new Semaphore(0);
    
    public synchronized void addNewObject(Object object) {
        objectList.add(object);
        semaphore.release();
    }
    
    public Object getNextObject() {
        synchronized (objectList) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return objectList.remove(0);
        }
    }
    
    public List<Object> getObjectList() {
        return objectList;
    }
}
