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
        multithreadingBuffer masterBuffer = new multithreadingBuffer();

        executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
        for(int i = 0; i < 10; i++){ // Creates 10 threads of slaves
            executorService.execute(new SlavesRootFinder(masterBuffer));
        }

        for(int i = 0; i < option; i++){
            try{
                Thread.sleep(100);
                masterBuffer.blockingPut(randomSetCoefficients());

                Thread.sleep(100);
                String[] roots = masterBuffer.blockingGetRoot();
                System.out.println("Root 1: " + roots[0] + " Root 2: " + roots[1]);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown(); // shut down ExecutorService--it decides when to shut down threads
    }

    private int[] randomSetCoefficients(){
        int[] setOfCoefficients = new int[3];
        SecureRandom generator = new SecureRandom();

        int i = 0;
        while(i < 3){
            setOfCoefficients[i] = generator.nextInt(-1000,1000); // Fix this
            i++;
        }

        return setOfCoefficients;
    }
}
