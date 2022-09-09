import java.io.FileWriter;
import java.util.Scanner; // So that I write to the screen
import java.io.File;
import java.io.FileReader; // Reads from file
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.*;


public class Decryptor {

    final static char alphabet [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public String DecryptMessage(int position, String keyList, String message){

        String decryptedMessage = "";
        return decryptedMessage;
    }

    public static void main(String[] args) {
        Decryptor decryptor = new Decryptor();

        /* This section gets the path and opens the files */
        System.out.println("This is the path: /Users/fatimakammona/Desktop/swd_fqkammona/oral_exam1/Homework3/src/keyFile.txt");
        System.out.print("Please enter the path to the key file: ");

        Scanner keyPath = new Scanner(System.in);
        String key = keyPath.nextLine();
        File keyFile = new File(key);

        System.out.println("This is the path: /Users/fatimakammona/Desktop/swd_fqkammona/oral_exam1/Homework3/src/keyFile.txtEncrypted.txt");
        System.out.print("Please enter the path to the encrypted file: ");

        Scanner encryptedPath = new Scanner(System.in);
        String encrypted = encryptedPath.nextLine();
        File encryptedFile = new File(encrypted);


        try{
            FileReader readKey = new FileReader(keyFile);
            BufferedReader keyRead = new BufferedReader(readKey);

            /* This section gets the position and keyList from the keyRead file */
            String positionInput = keyRead.readLine();
            int position = Integer.parseInt(positionInput); // Position needs to go 1 before than the give b/c arrays start at 0
            String keyList = keyRead.readLine();

            /* This section get the encrypted message */
           Scanner encrypt = new Scanner(encryptedFile);
           String encryptedMessage = encrypt.nextLine();


            /* This section class the function and then prints out the message */

            String decryptedMessage = decryptor.DecryptMessage(position,keyList, encryptedMessage);

            System.out.println(decryptedMessage);

            keyRead.close();

            /* This Section updates */

//            FileWriter writeKey = new FileWriter(keyFile);
//            BufferedWriter keyWrite = new BufferedWriter(writeKey);
//
//            keyWrite.append(String.valueOf(encryptor.position));

        //    keyWrite.append("\n" + keyList);
      //      keyWrite.close();

        }
        catch(Exception e) {
            System.out.println("Incorrect path has been entered.");
        }
    }
}

