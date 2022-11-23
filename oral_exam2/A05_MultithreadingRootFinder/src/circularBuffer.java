import java.util.concurrent.ArrayBlockingQueue;

public class circularBuffer implements buffer{
    private final ArrayBlockingQueue<String[]> buffering; // shared buffer

    public circularBuffer() {
        buffering = new ArrayBlockingQueue<String[]>(1);
    }

    @Override
    public void blockingPut(String[] value) throws InterruptedException {
        buffering.put(value);
    }

    @Override
    public String[] blockingGet() throws InterruptedException {
        return buffering.take();
    }
}
