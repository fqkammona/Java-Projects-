public interface Buffer {
    // place array of int coefficients into Buffer
    public void blockingPuttingArray(int[] value) throws InterruptedException;

    // return array of int coefficients from Buffer
    public int[] blockingGetArray() throws InterruptedException;
}
