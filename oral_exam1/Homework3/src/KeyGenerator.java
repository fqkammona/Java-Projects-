import java.util.Scanner; // So that I write to the screen
import java.io.File;
import java.io.FileWriter; // To write to a file
import java.io.IOException;

public class KeyGenerator {
    public static void main(String[] args) {
        System.out.println("Enter the name of the file you would like to create: ");

        Scanner inputFileName = new Scanner(System.in);
        String fileName = inputFileName.nextLine() + ".txt/";

        File keyFile = new File("/Users/fatimakammona/Desktop/swd_fqkammona/oral_exam1/Homework3/src/" + fileName);

        try{
            boolean fileCreated = keyFile.createNewFile(); // See if file is created
            if(fileCreated){
                System.out.println("Key File has been created.");
            }else {
                System.out.println("The key file already exists.");
            }

            FileWriter writeKey = new FileWriter(keyFile);

            /* This section creates the key and writes it to the file*/
            writeKey.write("key");


            writeKey.close(); // Close the file
        }
        catch(Exception e) {
            e.getStackTrace();
        }

//        System.out.println("Please choices a number to be your n. This number will be the starting point.");
//        System.out.print("Number: ");
//
//        int key = fileName.nextInt();

    }
}
