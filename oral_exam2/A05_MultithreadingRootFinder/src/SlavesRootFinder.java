import java.security.SecureRandom;

public class SlavesRootFinder implements Runnable {
    private final multithreadingBuffer masterBuffer; // reference to shared object
   // private final CircularBuffer slaveBuffer; // reference to shared object
    private static int number;

    public SlavesRootFinder(multithreadingBuffer masterBuffer) {
        this.masterBuffer = masterBuffer;
    }

    @Override
    public void run() {
        number++;
        System.out.println(number);

        try { // puts the thread to sleep for 1 second
            Thread.sleep(1000);

            double root1, root2;
            String rootString1, rootString2;

            int[] hold = masterBuffer.blockingGet();

            double a = hold[0];
            double b = hold[1];
            double c = hold[2];

            /* Solve for roots using Quadratic formula*/
            double determinantPart = Math.pow(b,2) - (4 * a * c);
            double otherPart = -b / (2 * a);

            if(determinantPart > 0){ // if real
                determinantPart = Math.sqrt(determinantPart) / (2 * a);
                root1 = otherPart + determinantPart;
                root2 = otherPart - determinantPart;

                rootString1 = Double.toString(root1);
                rootString2 = Double.toString(root2);

            } else { // imaginary
                determinantPart = Math.sqrt(-determinantPart) / (2 * a);
                rootString1 = otherPart + " +i " + determinantPart;
                rootString2 = otherPart + " -i " + determinantPart;
            }

            masterBuffer.blockingPut(rootString1, rootString2);

        }
        catch (InterruptedException exception) {
           //exception.printStackTrace();
            Thread.currentThread().interrupt(); // re-interrupt the thread
        }
    }
}
