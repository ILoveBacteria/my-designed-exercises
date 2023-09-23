import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class CarRequest implements Callable<Status> {
    private final String carName;
    private final AtomicInteger progress;
    
    public CarRequest(String carName, AtomicInteger progress) {
        this.carName = carName;
        this.progress = progress;
    }
    
    @Override
    public Status call() throws Exception {
        progress.incrementAndGet();
        try (Socket socket = new Socket("127.0.0.1", 5000)) {
            Formatter out = new Formatter(socket.getOutputStream());
            out.format(carName + "\n");
            out.flush();
            String result = new Scanner(socket.getInputStream()).next();
            return Status.valueOf(result);
        }
    }
}