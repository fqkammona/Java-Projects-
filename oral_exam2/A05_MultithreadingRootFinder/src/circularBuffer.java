// circularBuffer.java by Fatima Kammona

import java.util.concurrent.ArrayBlockingQueue; // Creates a synchronized buffer

public class circularBuffer implements buffer {
    private final ArrayBlockingQueue<String[]> buffering; // shared buffer

    public circularBuffer() {
        buffering = new ArrayBlockingQueue<>(1);
    }

    @Override // Adds the string array to buffering
    public void blockingPut(String[] value) throws InterruptedException {
        buffering.put(value);
    }

    @Override // Gets the string array from buffering
    public String[] blockingGet() throws InterruptedException {
        return buffering.take();
    }
}
