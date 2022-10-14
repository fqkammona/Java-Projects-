import java.security.SecureRandom;

public class SlavesRootFinder implements Runnable {
    private final Buffer sharedLocation; // reference to shared object
    private static int number;

    public SlavesRootFinder(Buffer sharedLocation)
    {
         this.sharedLocation = sharedLocation;
    }

    @Override
    public void run() {
        number++;
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
