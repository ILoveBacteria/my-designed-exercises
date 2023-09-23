import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CarRegisterSampleTest {
    private ServerSocket serverSocket;
    
    @Rule
    public Timeout globalTimeout = new Timeout(10000);
    
    @Before
    public void before() throws IOException {
        serverSocket = new ServerSocket(5000);
    }
    
    @After
    public void after() throws IOException {
        serverSocket.close();
    }
    
    @Test
    public void testSingleCarRegisterOK() throws Exception {
        CarRegister carRegister = new CarRegister(Stream.of("BMW").collect(Collectors.toList()));
        carRegister.startRegistering();
        Socket socket = serverSocket.accept();
        assertEquals("BMW", new Scanner(socket.getInputStream()).next());
        new Formatter(socket.getOutputStream()).format("OK\n").flush();
        Map<Status, Integer> result = carRegister.getFinalResult();
        assertEquals(1, result.get(Status.OK).intValue());
        assertEquals(0, result.get(Status.FAIL).intValue());
        assertEquals(0, result.get(Status.TIMEOUT).intValue());
    }
    
    @Test
    public void testMultiCarRegister() throws Exception {
        List<String> cars = Stream.of("BMW", "DIGNITY", "TARA", "SHAHIN").collect(Collectors.toList());
        CarRegister carRegister = new CarRegister(cars);
        carRegister.startRegistering();
        for (int i = 0; i < cars.size(); i++) {
            Socket socket = serverSocket.accept();
            if (new Scanner(socket.getInputStream()).next().equals("TARA"))
                new Formatter(socket.getOutputStream()).format("FAIL\n").flush();
            new Formatter(socket.getOutputStream()).format("OK\n").flush();
        }
        Map<Status, Integer> result = carRegister.getFinalResult();
        assertEquals(3, result.get(Status.OK).intValue());
        assertEquals(1, result.get(Status.FAIL).intValue());
        assertEquals(0, result.get(Status.TIMEOUT).intValue());
        
    }
    
    @Test
    public void testProgress() throws Exception {
        List<String> cars = Stream.of("BMW", "DIGNITY", "TARA", "SHAHIN").collect(Collectors.toList());
        CarRegister carRegister = new CarRegister(cars);
        carRegister.startRegistering();
        for (int i = 0; i < 3; i++) {
            serverSocket.accept();
        }
        assertEquals(75, carRegister.progress());
    }
}
