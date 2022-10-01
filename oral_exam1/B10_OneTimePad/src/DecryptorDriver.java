/* DecryptorDriver by Fatima Kammona */

/** This is the driver class for the Decryptor program.
 * ....FINISH
 * */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner; // So that I write to the screen

public class DecryptorDriver {
    public static void main(String[] args) {
        Decryptor decryptor = new Decryptor();

        /* This section gets the path for the key file */
        System.out.print("Please enter the path to the file: ");
        Scanner keyPathInput = new Scanner(System.in);
        Path keyPath = Paths.get(keyPathInput.nextLine()); // create Path object based on user input

        /* This section gets the encrypted message */
        System.out.print("Please enter the path to the encrypted file: ");
        Scanner encryptedPathInput = new Scanner(System.in);
        Path encryptedPath = Paths.get(encryptedPathInput.nextLine()); // create Path object based on user input

        if (Files.exists(keyPath) && Files.exists(encryptedPath)) // if path exists...
        {

            try{
                BufferedReader keyRead = new BufferedReader(new FileReader(keyPath.toFile()));

                /* This section gets the position and keyList from the keyRead file */
                String positionInput = keyRead.readLine();
                int position = Integer.parseInt(positionInput); // Position needs to go 1 before than the give b/c arrays start at 0
                String keyList = keyRead.readLine();

                /* This section get the encrypted message */
                Scanner encrypt = new Scanner(encryptedPath); // Scanner is slower however its reading only one line.
                String encryptedMessage = encrypt.nextLine();

                /* This section class the function and then prints out the message */
                String decryptedMessage = decryptor.DecryptMessage(position,keyList, encryptedMessage);
                System.out.println(decryptedMessage);
                keyRead.close();
            }
            catch(Exception e) {
                System.out.println("Incorrect path has been entered.");
            }
        }
        else if (!Files.exists(keyPath))// not file or directory, output error message
        {
            System.out.printf("%s does not exist%n", keyPath);
        }else {
            System.out.printf("%s does not exist%n", encryptedPath);
        }
    }
}
