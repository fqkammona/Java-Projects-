public interface buffer {
    public void blockingPut(String[] value) throws InterruptedException;

    // return String[] value from Buffer
    public String[] blockingGet() throws InterruptedException;
}
