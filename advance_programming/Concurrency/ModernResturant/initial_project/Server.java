import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private final Resource resource;
    
    public Server(Resource resource) {
        this.resource = resource;
    }
    
    @Override
    public void run() {
        // TODO: Implement
    }
}
