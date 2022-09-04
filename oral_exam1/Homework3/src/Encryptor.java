import java.io.FileWriter;
import java.util.Scanner; // So that I write to the screen
import java.io.File;
import java.io.FileReader; // Reads from file
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Encryptor {

    final static char alphabet [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void main(String[] args) {
        System.out.println("This is the path: /Users/fatimakammona/Desktop/swd_fqkammona/oral_exam1/Homework3/src/keyFile.txt");
        System.out.print("Please enter the path to the file: ");

        Scanner path = new Scanner(System.in);
        String fileName = path.nextLine();

        try {
            File keyFile = new File(fileName);
            Scanner key = new Scanner(keyFile);

            String output = key.nextLine();
            System.out.println(output);

            key.close();
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect path has been entered.");
        }

    }
}
