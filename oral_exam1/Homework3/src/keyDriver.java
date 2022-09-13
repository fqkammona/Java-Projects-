import java.util.Scanner; // So that I write to the screen
import java.io.File;
import java.io.FileWriter; // To write to a file
import java.lang.Math; //importing this class so i can use math.Random


public class keyDriver {

    public static void main(String[] args) {
        KeyGenerator keyG = new KeyGenerator();
        System.out.print("Enter the name of the file you would like to create: ");

        Scanner inputFileName = new Scanner(System.in);
        String fileName = inputFileName.nextLine() + ".txt/";

        ////        while(fileName == " .txt/"){
////            System.out.println("Please enter a name: ");
////
////            Scanner inputFilebame = new Scanner(System.in);
////            fileName = inputFilebame.nextLine() + ".txt/";
////        }

        File keyFile = new File("/Users/fatimakammona/Desktop/swd_fqkammona/oral_exam1/Homework3/src/" + fileName);

        try{
            boolean fileCreated = keyFile.createNewFile(); // See if file is created
            if(!fileCreated){ // If the file has already been created
                System.out.println("The key file already exists.");
            }else {
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

                writeKey.write("\n" + keyG.createKeyList(nValues));

                writeKey.close(); // You have to close the file
            }

        }
        catch(Exception e) {
            System.out.println("Incorrect path has been entered.");
        }
    }
}
