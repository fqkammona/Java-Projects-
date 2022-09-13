import java.io.FileWriter;
import java.util.Scanner; // So that I write to the screen
import java.io.File;
import java.io.FileReader; // Reads from file
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.*;

public class EncryptorDriver {
    public static void main(String[] args) {
        Encryptor encryptor = new Encryptor();

        /* This section gets the path and the message */
        System.out.println("This is the path: /Users/fatimakammona/Desktop/swd_fqkammona/oral_exam1/Homework3/src/keyFile.txt");
        System.out.print("Please enter the path to the file: ");

        Scanner path = new Scanner(System.in);
        String fileName = path.nextLine();

        System.out.print("Please enter the message: ");
        Scanner inputMessage = new Scanner(System.in);

        String message = inputMessage.nextLine();
        message = message.toUpperCase(); // converts the message to uppercase

        File keyFile = new File(fileName);

        /* This section creates the encrypted file */
        String nameOfFile ="Encrypted." + keyFile.getName();
        File encryptorFile = new File("/Users/fatimakammona/Desktop/swd_fqkammona/oral_exam1/Homework3/src/" + nameOfFile);


        try{
            FileReader readKey = new FileReader(keyFile);
            BufferedReader keyRead = new BufferedReader(readKey);

            /* This section gets the position and keyList from the file */
            String positionInput = keyRead.readLine();
            int position = Integer.parseInt(positionInput); // Position needs to go 1 before than the give b/c arrays start at 0

            String keyList = keyRead.readLine();

            /* This section class the encryptor function and then prints it out and closes the file */

            encryptor.setPosition(position);
            String encryptedMessage = encryptor.EncryptMessage(keyList, message);
            System.out.println("Message has been encrypted");
            keyRead.close();

            /* This Section updates */

            FileWriter writeKey = new FileWriter(keyFile);
            BufferedWriter keyWrite = new BufferedWriter(writeKey);

            keyWrite.append(String.valueOf(encryptor.getPosition()));
            keyWrite.append("\n" + keyList);
            keyWrite.close();

            /* This section creates a new file with */

            FileWriter encryptedFile = new FileWriter(encryptorFile);
            encryptedFile.write(encryptedMessage);
            encryptedFile.close();

        }
        catch(Exception e) {
            System.out.println("Incorrect path has been entered.");
        }
    }
}
