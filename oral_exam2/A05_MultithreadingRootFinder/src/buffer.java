// buffer.java by Fatima Kammona
public interface buffer {
    void blockingPut(String[] value) throws InterruptedException; // puts String[] value in buffer

    String[] blockingGet() throws InterruptedException; // return String[] value from Buffer
}
