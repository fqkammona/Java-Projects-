import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.security.SecureRandom;
public class MasterRootFinder {

    //
    public void createThreads(){

        // create ExecutorService to manage threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // create CircularBuffer to store the setOfCoefficients
        CircularBuffer sharedLocation = new CircularBuffer();

        for(int i = 0; i < 10; i++){ // Creates 10 threads of slaves
            executorService.execute(new SlavesRootFinder(sharedLocation));
        }
        // shut down ExecutorService--it decides when to shut down threads
        executorService.shutdown();
    }

    public int[] randomSetCoefficients(){
        int[] setOfCoefficients = new int[3];
        SecureRandom generator = new SecureRandom();

        int i = 0;
        while(i < 3){
            setOfCoefficients[i] = generator.nextInt(-1000,1000); // Fix this
            i++;
        }

// put them in  master Buffer
        return setOfCoefficients;
    }
}
