import java.io.FileWriter;
import java.util.Scanner; // So that I write to the screen
import java.io.File;
import java.io.FileReader; // Reads from file
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.*;

public class Encryptor {

    final static char alphabet [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private int position;
    public void setPosition(int position){ this.position = position;}

    public String EncryptMessage(int position, String keyList, String message){
        position--; // You have to sub track by one because arrays start at zero
        String[] keyArray = keyList.split("[,]",0); // makes an array(size 21) of strings of each element of
        String encryptedMessage = "";

        int i = 0;

        while(i < message.length()){ // Loop until we have gone through the whole message

            /* This section finds the index of the letter form the alphabet */
            int index = -1; // To know if the char is not a letter
            char letter = message.charAt(i); // Take the char of the old message, one letter at a time

            for (int k = 0; k < alphabet.length; k++) { // For loop to find the index of the char
                char tempLetter = alphabet[k];

                if (letter == tempLetter) {
                    index = k;
                }
            }

            // Now we have the index i.e M = 12//

            String newLetter = "";

            if(index == -1){ // If the index is still -1 then we know it is not a letter therefor it doesn't change
                newLetter = String.valueOf(letter);
            }else{
                if(position > keyArray.length -1){ // If we get to the end of the array
                    position = position - keyArray.length; // Change the position to the start of the array
                }else{ // If not we go to the next position
                    position++;
                }

                int keyIndex = Integer.parseInt(keyArray[position]); // Gets the value of n and changes it into an int
                int newIndex = index + keyIndex;

                if(newIndex > 25){ // if we are at the end of the alphabet
                    newIndex = newIndex - 26; // subtract the alphabet. Since arrays start at 0 we need to subtract 26 instead of 25
                }

                newLetter = String.valueOf(alphabet[newIndex]); // converting the new letter from a char to a string

            }

            encryptedMessage = encryptedMessage + newLetter; // Adding the newLetter to the newMessage

            i++;
        }

        setPosition(position + 1); // We add by one because we went back by one at the start so we need to account for it.
        return encryptedMessage;
    }

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

        String nameOfFile = keyFile.getName() + "Encrypted.txt";

        File encryptorFile = new File("/Users/fatimakammona/Desktop/swd_fqkammona/oral_exam1/Homework3/src/" + nameOfFile);


        try{
            FileReader readKey = new FileReader(keyFile);
            BufferedReader keyRead = new BufferedReader(readKey);

            /* This section gets the position and keyList from the file */
            String positionInput = keyRead.readLine();
            int position = Integer.parseInt(positionInput); // Position needs to go 1 before than the give b/c arrays start at 0
//            System.out.println(position);

            String keyList = keyRead.readLine();

            /* This section class the encryptor function and then prints it out and closes the file */

            String encryptedMessage = encryptor.EncryptMessage(position,keyList, message);
//            System.out.println(encryptedMessage);
//            System.out.println(encryptor.position);
            System.out.println("Message has been encrypted");

            keyRead.close();

            /* This Section updates */

            FileWriter writeKey = new FileWriter(keyFile);
            BufferedWriter keyWrite = new BufferedWriter(writeKey);

            keyWrite.append(String.valueOf(encryptor.position));

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
//
//        try {
//            File keyFile = new File(fileName);
//            Scanner readKey = new Scanner(keyFile);
//
//            /* This section gets the position and keyList from the file */
//            String positionInput = readKey.nextLine();
//            int position = Integer.parseInt(positionInput); // Position needs to go 1 before than the give b/c arrays start at 0
//            System.out.println(position);
//
//            String keyList = readKey.nextLine();
//
//            String encryptedMessage = encryptor.EncryptMessage(position,keyList, message);
//            System.out.println(encryptedMessage);
//            System.out.println(encryptor.position);
//
//            readKey.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Incorrect path has been entered.");
//        }

//        try {
//            FileWriter keyWrite = new FileWriter(fileName);
//            BufferedWriter writePosition = new BufferedWriter(keyWrite);
//
//            FileReader keyRead = new FileReader(fileName);
//
//            keyRead.read();
//
//        }
//        catch(Exception e) {
//            System.out.println("Incorrect path has been entered.");
//        }



    }
}
