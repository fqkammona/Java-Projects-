import java.security.SecureRandom;

public class SlavesRootFinder implements Runnable {

    private int number;

    public SlavesRootFinder(int number){
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(number);

        try { // puts the thread to sleep for 1 second
            Thread.sleep(1000);
        }
        catch (InterruptedException exception) {
           //exception.printStackTrace();
           // Thread.currentThread().interrupt(); // re-interrupt the thread
        }
    }
}
