import java.io.FileWriter;
import java.util.Scanner; // So that I write to the screen
import java.io.File;
import java.io.FileReader; // Reads from file
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Encryptor {

    final static char alphabet [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

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
                if(position >= keyArray.length){ // If we get to the end of the array
                    position = position - keyArray.length; // Change the position to the start of the array
                }

                int keyIndex = Integer.parseInt(keyArray[position]); // Gets the value of n and changes it into an int
                int newIndex = index + keyIndex;

                if(newIndex > 25){ // if we are at the end of the alphabet
                    newIndex = newIndex - 26; // subtract the alphabet. Since arrays start at 0 we need to subtract 26 instead of 25
                }

                // char newLetter = alphabet[newIndex]; // The new letter
                newLetter = String.valueOf(alphabet[newIndex]); // converting the new letter from a char to a string

            }

            encryptedMessage = encryptedMessage + newLetter; // Adding the newLetter to the newMessage

            position++;
            i++;
        }

        return encryptedMessage;
    }

    public static void main(String[] args) {
        Encryptor encryptor = new Encryptor();

        /* This section gets the path and the message */
        System.out.println("This is the path: /Users/fatimakammona/Desktop/swd_fqkammona/oral_exam1/Homework3/src/keyList.txt");
        System.out.print("Please enter the path to the file: ");

        Scanner path = new Scanner(System.in);
        String fileName = path.nextLine();

        System.out.print("Please enter the message: ");
        Scanner inputMessage = new Scanner(System.in);

        String message = inputMessage.nextLine();
        message = message.toUpperCase(); // converts the message to uppercase


        try {
            File keyFile = new File(fileName);
            Scanner readKey = new Scanner(keyFile);

            /* This section gets the position and keyList from the file */
            String positionInput = readKey.nextLine();
            int position = Integer.parseInt(positionInput); // Position needs to go 1 before than the give b/c arrays start at 0

            String keyList = readKey.nextLine();

            String encryptedMessage = encryptor.EncryptMessage(position, keyList, message);
            System.out.println(encryptedMessage);


            readKey.close();
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect path has been entered.");
        }



    }
}
