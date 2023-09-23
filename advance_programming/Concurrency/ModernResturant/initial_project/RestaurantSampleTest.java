import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RestaurantSampleTest {
    private static final ExecutorService executor = Executors.newFixedThreadPool(2);
    
    @Rule
    public Timeout globalTimeout = new Timeout(10000);
    
    @BeforeClass
    public static void beforeClass() {
        Resource resource = new Resource();
        Server server = new Server(resource);
        Kitchen kitchen = new Kitchen(resource);
        executor.execute(kitchen);
        executor.execute(server);
    }
    
    @Test
    public void testSingleClientOrder() throws IOException {
        int PORT = 5000;
        try (Socket socket = new Socket("localhost", PORT)) {
            Order order = new Order(1, 1000);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(order);
            out.flush();
            assertEquals(order.getId() + " is ready", new Scanner(socket.getInputStream()).nextLine().trim());
        }
    }
}
