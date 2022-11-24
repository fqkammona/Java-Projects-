// MasterRootFinder.java by Fatima Kammona
/* This class creates 10 threads and adds set of coefficients to a masterBuffer which is shared with the
 SlavesRootFinder.java class that solves the sets and puts them in slaveBuffer which is shared with the master. */

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class MasterRootFinder {

    /**
     * This class pulls the threads and excutes them and then goes through a for loop of either 30 or 3000 that
     * add sets of coefficients in a shared buffer with the slave that will solve the sets.
     */
    public void createThreads(int option) throws InterruptedException {
        /* create ExecutorService to manage threads */
        ExecutorService executorService = Executors.newCachedThreadPool();

        /* create circularBuffers to store the setOfCoefficients */
        circularBuffer masterBuffer = new circularBuffer();
        circularBuffer slaveBuffer = new circularBuffer();

        for (int i = 0; i < 10; i++) { // Creates 10 threads of slaves
            executorService.execute(new SlavesRootFinder(masterBuffer, slaveBuffer, i + 1));
        }

        boolean printStats = option == 3000;// if(options == 300) printStats == true
        for (int i = 0; i < option; i++) {
            try {
                Thread.sleep(100);
                double[] hold = randomSetCoefficients();
                String[] value = new String[3];

                for (int j = 0; j < hold.length; j++) {
                    value[j] = String.valueOf(hold[j]);
                }

                masterBuffer.blockingPut(value);
                Thread.sleep(100);
                String[] roots = slaveBuffer.blockingGet();

                if (!printStats)
                    System.out.println("Root 1: " + roots[0] + " Root 2: " + roots[1]);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }

        if (!printStats) {
            HashMap<Integer, Integer> stats = SlavesRootFinder.getSlaveStats();
            System.out.print("1");

            for (int threadsStats = 1; threadsStats <= 10; threadsStats++) {
                System.out.println("Thread:  " + threadsStats + " Sets Solved: " + stats.get(threadsStats));
            }
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

    /**
     * This method creates and returns an array of random coefficients using Math.random and Math.floor
     */
    private double[] randomSetCoefficients() {
        double[] setOfCoefficients = new double[3];
        int min = -1000;
        int max = 1000;

        int i = 0;
        while (i < 3) {
            setOfCoefficients[i] = Math.floor(Math.random() * (max - min + 1) + min);
            i++;
        }
        return setOfCoefficients;
    }
}
