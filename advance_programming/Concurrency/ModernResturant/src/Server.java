import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Server implements Runnable {
    private final Resource resource;
    private Lock lock;
    
    public Server(Resource resource) {
        this.resource = resource;
    }
    
    @Override
    public void run() {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(5000);
                 Socket socket = serverSocket.accept()) {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Order order = (Order) objectInputStream.readObject();
                resource.addNewOrder(order);
                synchronized (order) {
                    order.wait();
                }
                Formatter formatter = new Formatter(socket.getOutputStream());
                formatter.format(order.getId() + " is ready");
                formatter.flush();
            } catch (IOException | ClassNotFoundException e) {
                e.getStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
