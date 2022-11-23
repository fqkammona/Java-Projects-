// SlavesRootFinder.java by Fatima Kammona

import java.util.HashMap;

public class SlavesRootFinder implements Runnable {
    /*References to shared objects */
    private final circularBuffer masterBuffer;
    private final circularBuffer slaveBuffer;
    private final int numberOfSlave;

    /* Keeps track of the amount of roots solved per thread */
    private static final HashMap<Integer,Integer> slaveStats = new HashMap<>();
    public SlavesRootFinder(circularBuffer masterBuffer, circularBuffer slaveBuffer, int numberOfSlave){
        this.masterBuffer = masterBuffer;
        this.slaveBuffer = slaveBuffer;
        this.numberOfSlave = numberOfSlave;
        slaveStats.put(numberOfSlave, 0);
    }

    /** This method updates the slaveStats and get the coefficients from the master and then does all the math
     * for finding the roots and then puts it in the slaveBuffer. */
    @Override
    public void run() {
        try { // puts the thread to sleep for 1 second
//            Thread.sleep(1000);

            /* Updates the number of roots solved for the thread */
            slaveStats.put(numberOfSlave,slaveStats.get(numberOfSlave)+1);

            double root1, root2;
            String rootString1, rootString2;

            String[] hold = masterBuffer.blockingGet();

            double a = Double.parseDouble(hold[0]);
            double b = Double.parseDouble(hold[1]);
            double c = Double.parseDouble(hold[2]);

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
            slaveBuffer.blockingPut(new String[]{rootString1, rootString2});
        }
        catch (InterruptedException exception) {
            Thread.currentThread().interrupt(); // re-interrupt the thread
        }
    }

    /** Returns the Statics for the threads */
    public static HashMap<Integer, Integer> getSlaveStats(){
        return slaveStats;
    }
}
