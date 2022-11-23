// DriverRootFinder.java by Fatima Kammona

import java.util.InputMismatchException;
import java.util.Scanner;
public class DriverRootFinder {
    public static void main(String[] args) throws InterruptedException {
       MasterRootFinder rootFinder = new MasterRootFinder();
       boolean optionValid = false;
       Scanner in = new Scanner(System.in);
       int optionNumber = 0;

       // Try catch to catch when a letter is entered
        try {
            while(!optionValid){ // To make sure only 1 or 2 is inputed
                System.out.println("Option 1: 30 Sets");
                System.out.println("Option 2: 3000 Sets");
                System.out.print("Please enter the number of the option you would like: ");

                optionNumber = in.nextInt();
                if(optionNumber == 1 || optionNumber == 2)
                    optionValid = true;

            }

            if(optionNumber == 1){
                rootFinder.createThreads(30);
            } else {
                rootFinder.createThreads(3000);
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("Error: Please enter a correct option");
        }
    }
}


