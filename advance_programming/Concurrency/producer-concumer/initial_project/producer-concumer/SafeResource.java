import java.util.ArrayList;
import java.util.List;

public class SafeResource {
    private final List<Object> objectList = new ArrayList<>();
    
    public synchronized void addNewObject(Object object) {
        // TODO: Implement
    }
    
    public Object getNextObject() {
        // TODO: Implement
    }
    
    public List<Object> getObjectList() {
        return objectList;
    }
}
