import java.util.concurrent.ArrayBlockingQueue;

public class multithreadingBuffer {
    private final ArrayBlockingQueue<int[]> masterBuffer; // shared buffer
    private final ArrayBlockingQueue<String[]> slaveBuffer; // shared buffer

    public multithreadingBuffer() {
        masterBuffer = new ArrayBlockingQueue<int[]>(1);
        slaveBuffer = new ArrayBlockingQueue<String[]>(1);
    }

    public void blockingPut(int[] values) throws InterruptedException {
        masterBuffer.put(values);
    }

    public int[] blockingGet() throws InterruptedException {
        return masterBuffer.take();
    }

    public void blockingPut(String root1, String root2) throws InterruptedException {
        slaveBuffer.put(new String[]{root1, root2});
    }

    public String[] blockingGetRoot() throws InterruptedException {
        return slaveBuffer.take();
    }
}
