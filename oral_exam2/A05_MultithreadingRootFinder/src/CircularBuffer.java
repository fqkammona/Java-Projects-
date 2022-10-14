public class CircularBuffer implements Buffer {
    private int[] buffer = new int[3]; // shared buffer

    private int head = 0; // index of next element to write to
    private int tail = 0; // index of next element to read

    @Override
    public synchronized void blockingPuttingArray(int[] value)
            throws InterruptedException {
        buffer = value;
    }

    @Override
    public synchronized int[] blockingGetArray() throws InterruptedException {

        return buffer;
    }
}
