/* EncryptorDriver by Fatima Kammona */

/** This is the driver class for the Encryptor program.
 * ....FINISH
 * */

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner; // So that I write to the screen
import java.io.File;
import java.io.FileReader; // Reads from file
//import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class EncryptorDriver {
    public static void main(String[] args) { //throws FileNotFoundException
        Encryptor encryptor = new Encryptor();

        /* This section gets the path and the message */
      //  System.out.println("This is the path: /iahome/f/fq/fqkammona/IdeaProjects/fqkammona_swd/oral_exam1/Homework3/src/keyFile2.txt");
        System.out.print("Please enter the path to the file: ");

        // create Path object based on user input
        Scanner keyPathInput = new Scanner(System.in);
        Path path = Paths.get(keyPathInput.nextLine()); // create Path object based on user input

        if (Files.exists(path)) // if path exists...
        {
            /* This section creates the encrypted file */
            String nameOfFile ="Encrypted." + path.getFileName();
            File encryptorFile = new File("/iahome/f/fq/fqkammona/IdeaProjects/fqkammona_swd/oral_exam1/B10_OneTimePad/src/" + nameOfFile);

            System.out.print("File has been found.\nPlease enter the message: ");
            Scanner inputMessage = new Scanner(System.in);

            String message = inputMessage.nextLine();
            message = message.toUpperCase(); // converts the message to uppercase

            try{
                /* */
                BufferedReader keyRead = new BufferedReader(new FileReader(path.toFile()));

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

                BufferedWriter keyWrite = new BufferedWriter(new FileWriter(path.toFile()));

                keyWrite.append(String.valueOf(encryptor.getPosition()));
                keyWrite.append("\n" + keyList);
                keyWrite.close();

                /* This section creates a new file with */

                FileWriter encryptedFile = new FileWriter(encryptorFile);
                encryptedFile.write(encryptedMessage);
                encryptedFile.close();

            }  catch(Exception e) {
            System.out.println("Error has occurred while Encrypting");
            }
        }
        else // not file or directory, output error message
        {
            System.out.printf("%s does not exist%n", path);
        }
    }
}

