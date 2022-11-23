import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class MasterRootFinder {
    public ExecutorService executorService;
    public void createThreads(int option) throws InterruptedException {
        /* create ExecutorService to manage threads */
        executorService = Executors.newCachedThreadPool();

        /* create CircularBuffer to store the setOfCoefficients */
       // multithreadingBuffer masterBuffer = new multithreadingBuffer();
        circularBuffer masterBuffer= new circularBuffer();
        circularBuffer slaveBuffer = new circularBuffer();

        executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
        for(int i = 0; i < 10; i++){ // Creates 10 threads of slaves
            //executorService.execute(new SlavesRootFinder(masterBuffer, i + 1));
            executorService.execute(new SlavesRootFinder(masterBuffer,slaveBuffer, i + 1));
        }

        for(int i = 0; i < option; i++){
            try{
                Thread.sleep(100);
                double[] hold = randomSetCoefficients();
                // masterBuffer.blockingPut(hold);

                String[] value = new String[3];

                for(int j = 0; j < hold.length; j++){
                    value[j] = String.valueOf(hold[j]);
                }

                masterBuffer.blockingPut(value);

                Thread.sleep(100);
               // String[] roots = masterBuffer.blockingGetRoot();
                String[] roots = slaveBuffer.blockingGet();
                System.out.println("Root 1: " + roots[0] + " Root 2: " + roots[1]);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        executorService.shutdown(); // shut down ExecutorService--it decides when to shut down threads
        System.exit(0);
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
