import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CarRegister {
    private final List<String> cars;
    private final AtomicInteger progress = new AtomicInteger(0);
    private Future<Map<Status, Integer>> resultFuture;
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    
    public CarRegister(List<String> cars) {
        this.cars = cars;
    }
    
    public void startRegistering() {
        List<CarRequest> requests = cars.stream().map(car -> new CarRequest(car, progress)).collect(Collectors.toList());
        resultFuture = executorService.submit(new CarRegisterHandler(requests));
    }
    
    public Map<Status, Integer> getFinalResult() throws ExecutionException, InterruptedException {
        return resultFuture.get();
    }
    
    public int progress() {
        return progress.get() * 100 / cars.size();
    }
}

class CarRegisterHandler implements Callable<Map<Status, Integer>> {
    private final List<CarRequest> requests;
    private final Map<Status, Integer> statusResult = new EnumMap<>(Status.class);
    
    public CarRegisterHandler(List<CarRequest> requests) {
        this.requests = requests;
        statusResult.put(Status.OK, 0);
        statusResult.put(Status.FAIL, 0);
        statusResult.put(Status.TIMEOUT, 0);
    }
    
    @Override
    public Map<Status, Integer> call() throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        List<Future<Status>> futureResults = es.invokeAll(requests, 5, TimeUnit.SECONDS);
        for (Future<Status> f : futureResults) {
            try {
                Status result = f.get();
                statusResult.put(result, statusResult.get(result) + 1);
            } catch (CancellationException e) {
                statusResult.put(Status.TIMEOUT, statusResult.get(Status.TIMEOUT) + 1);
            }
        }
        return statusResult;
    }
}
