import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
public class MasterRootFinder {

    public void createThreads(){

        // create ExecutorService to manage threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i < 10; i++){ // Creates 10 threads of slaves
            SlavesRootFinder mySlaveFinder = new SlavesRootFinder(i);
            executorService.execute(mySlaveFinder);
        }

        // shut down ExecutorService--it decides when to shut down threads
        executorService.shutdown();
    }
}
