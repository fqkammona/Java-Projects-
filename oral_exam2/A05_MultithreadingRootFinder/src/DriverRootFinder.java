import java.util.Scanner;

public class DriverRootFinder {
    public static void main(String[] args) throws InterruptedException {
       MasterRootFinder rootFinder = new MasterRootFinder();

       System.out.print("Input 30 or Input 3000: ");
       Scanner in = new Scanner(System.in);

       // Make sure its either 30 or 3000

       rootFinder.createThreads(in.nextInt());
    }
}
