public class Main {
    public static void main(String[] args) throws InterruptedException {
        SafeResource safeResource = new SafeResource();
        Producer producer = new Producer(safeResource);
        Consumer consumer = new Consumer(safeResource);
        consumer.start();
        producer.start();
        consumer.join();
        producer.join();
    }
}