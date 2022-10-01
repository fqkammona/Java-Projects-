/* keyDriver by Fatima Kammona */

/** This is the driver class for the keyGenerator program.
 * The program promts the user to give in the file name and verifyies that the file does
 * not already exist. And then takes more user info.....FINISH
 * */

import java.io.*;
import java.util.Scanner; // So that I write to the screen

public class keyDriver {

    public static void main(String[] args) {
        KeyGenerator key = new KeyGenerator();

        System.out.print("Enter the name of the file you would like to create: ");

        Scanner inputFileName = new Scanner(System.in);
        String fileName = inputFileName.nextLine() + ".txt";

        File keyFile = new File("/iahome/f/fq/fqkammona/IdeaProjects/fqkammona_swd/oral_exam1/B10_OneTimePad/src/"+ fileName);

        try{
            if(!keyFile.createNewFile()){ // If the file has already been created
                System.out.println("The key file already exists.");
            } else {
                System.out.println("Key File has been created.");

                /* This section gets the number of n values and the starting position */
                System.out.print("\nPlease enter how many n values you would like: ");
                Scanner values = new Scanner(System.in);
                int nValues = values.nextInt();

                System.out.print("What position would you like to start at: ");
                Scanner nPosition = new Scanner(System.in);
                int position = nPosition.nextInt();

                /* This section writes the information to the file */
                FileWriter writeKey = new FileWriter(keyFile);

                writeKey.write(String.valueOf(position)); // you have to change the integer into a string.

                writeKey.write("\n" + key.createKeyList(nValues)); // is this using anonymous?

                writeKey.close(); // You have to close the file
            }
        }
        catch(Exception e) {
            System.out.println("Incorrect path has been entered.");
        }
    }
}
