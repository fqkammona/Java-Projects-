import java.security.SecureRandom;

public class SlavesRootFinder implements Runnable {
   // private final multithreadingBuffer masterBuffer; // reference to shared object
   // private final CircularBuffer slaveBuffer; // reference to shared object

    private final circularBuffer masterBuffer;
    private final circularBuffer slaveBuffer;
    private int numberOfSlave;

//    public SlavesRootFinder(multithreadingBuffer masterBuffer, int numberOfSlave) {
//        this.masterBuffer = masterBuffer;
//        this.numberOfSlave = numberOfSlave;
//    }

    public SlavesRootFinder(circularBuffer masterBuffer, circularBuffer slaveBuffer, int numberOfSlave){
        this.masterBuffer = masterBuffer;
        this.slaveBuffer = slaveBuffer;
        this.numberOfSlave = numberOfSlave;
    }

    @Override
    public void run() {
//        number++;
        System.out.println(numberOfSlave);

        try { // puts the thread to sleep for 1 second
            Thread.sleep(1000);

            double root1, root2;
            String rootString1, rootString2;

           // int[] hold = masterBuffer.blockingGet();
            String[] hold = masterBuffer.blockingGet();

//            double a = hold[0];
//            double b = hold[1];
//            double c = hold[2];

            double a = Double.parseDouble(hold[0]);
            double b = Double.parseDouble(hold[1]);
            double c = Double.parseDouble(hold[2]);

         //   System.out.println(a + " " + b  + " " + c);
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
                rootString1 = otherPart + " + " + determinantPart + "i";
                rootString2 = otherPart + " - " + determinantPart + "i";
            }

            // masterbuffer.blockingPut(rootString1, rootString2);
           // String[] temp = new String[]{rootString1, rootString2};

            //System.out.println(rootString1);

            slaveBuffer.blockingPut(new String[]{rootString1, rootString2});


        }
        catch (InterruptedException exception) {
            Thread.currentThread().interrupt(); // re-interrupt the thread
        }
    }
}
