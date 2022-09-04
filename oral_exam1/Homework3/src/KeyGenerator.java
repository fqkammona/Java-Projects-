import java.util.Scanner; // So that I write to the screen
import java.io.File;
import java.io.IOException;


public class KeyGenerator {
    public static void main(String[] args) {
       System.out.println("Enter the name of the file you would like to create: ");

        Scanner fileName = new Scanner(System.in);
        File keyFile = new File(fileName.nextLine()); // Creates the file

        try{
            boolean fileCreated = keyFile.createNewFile(); // See if file is created
            if(fileCreated){
                System.out.println("Key File has been created.");
            }else {
                System.out.println("The key file already exists.");
            }
        }
        catch(Exception e) {
            e.getStackTrace();
        }

        System.out.println("Please choices a number to be your n. This number will be the starting point.");
        System.out.print("Number: ");

        int key = fileName.nextInt();

    }
}
