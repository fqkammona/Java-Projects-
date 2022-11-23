// MasterRootFinder.java by Fatima Kammona

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
public class MasterRootFinder {
    public ExecutorService executorService;
    public void createThreads(int option) throws InterruptedException {
        /* create ExecutorService to manage threads */
        executorService = Executors.newCachedThreadPool();

        /* create circularBuffers to store the setOfCoefficients */
        circularBuffer masterBuffer= new circularBuffer();
        circularBuffer slaveBuffer = new circularBuffer();


        for(int i = 0; i < 10; i++){ // Creates 10 threads of slaves
            executorService.execute(new SlavesRootFinder(masterBuffer,slaveBuffer, i + 1));
        }

        // if(options == 300) printStats == true
        boolean printStats = option == 3000;

        for(int i = 0; i < 11; i++){
            try{
                Thread.sleep(100);
                double[] hold = randomSetCoefficients();
                String[] value = new String[3];

                for(int j = 0; j < hold.length; j++){
                    value[j] = String.valueOf(hold[j]);
                }

                masterBuffer.blockingPut(value);

               Thread.sleep(100);
               String[] roots = slaveBuffer.blockingGet();

                if(!printStats)
                    System.out.println("Root 1: " + roots[0] + " Root 2: " + roots[1]);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.printf(
                "Producer done producing%nTerminating Producer%n");

//        if(printStats){
//            HashMap<Integer,Integer> stats = SlavesRootFinder.getSlaveStats();
//            System.out.print("1");
//
//            for(int threadsStats = 1; threadsStats <= 10; threadsStats++){
//                System.out.println("Thread:  " + threadsStats + " Sets Solved: " + stats.get(threadsStats));
//            }
//        }

      //  executorService.shutdown(); // shut down ExecutorService--it decides when to shut down threads
       // System.exit(0);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

    private double[] randomSetCoefficients(){
        double[] setOfCoefficients = new double[3];
        int min = -1000;
        int max = 1000;

        int i = 0;
        while(i < 3){
            setOfCoefficients[i] = Math.floor(Math.random()*(max-min+1)+min);
            i++;
        }

        return setOfCoefficients;
    }
}
