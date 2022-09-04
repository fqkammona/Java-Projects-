import java.util.Scanner;
import java.lang.Math; //importing this class so i can use math.Random
import java.lang.String;

public class OneTimePad {
    final static char alphabet [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private int key;
    private String keyList;
    private String message;

    private void setKeyList(String keyList){
        this.keyList = keyList;
    }

    private String getKeyList(){
        return keyList;
    }
    public void setKey(int key){
        this.key = key;
    }

    public void setMessage(String message){
        this.message = message.toUpperCase(); // converts the message to uppercase
    }

    public int getKey(){
        return key;
    }

    public String getMessage(){
        return message;
    }

    public String EncryptMessage1(){
        String OldMessage = message;
        String newMessage = "";

        int key = this.key;

        int i = 0;
        while(i < OldMessage.length()){ // While loop until the end of the message
            int index = -1; // To know if the char is not a letter
            char letter = OldMessage.charAt(i); // Take the char of the old message, one letter at a time

            for (int k = 0; k < alphabet.length; k++){ // For loop to find the index of the char
                char tempLetter = alphabet[k];

                if(letter == tempLetter){
                    index = k;
                }
            }
            // At this point we have the index //

            String newLetter = "";

            if(index == -1){ // If the index is still -1 then we know it is not a letter therefor it doesn't change
                newLetter = String.valueOf(letter);
            }else{
                int newIndex = index + key;
                if(newIndex > 25){ // if we are at the end of the alphabet
                    newIndex = newIndex - 26; // subtract the alphabet. Since arrays start at 0 we need to subtract 26 instead of 25
                }

                // char newLetter = alphabet[newIndex]; // The new letter
                newLetter = String.valueOf(alphabet[newIndex]); // converting the new letter from a char to a string
            }

            newMessage = newMessage + newLetter; // Adding the newLetter to the newMessage

            i++;
        }

        return newMessage;
    }

    public String DecryptMessage(){
        String encryptMess = message;
        String decryptMess = "";

        int key = this.key;

        int i = 0;
        while(i < encryptMess.length()){
            int index = -1; // To know if the char is not a letter
            char letter = encryptMess.charAt(i); // Take the char of the old message, one letter at a time

            for (int k = 0; k < alphabet.length; k++){ // For loop to find the index of the char
                char tempLetter = alphabet[k];

                if(letter == tempLetter){
                    index = k;
                }
            }

            // At this point we have the index //

            String newLetter = "";

            if(index == -1){ // If the index is still -1 then we know it is not a letter therefor it doesn't change
                newLetter = String.valueOf(letter);
            }else{
                int newIndex = index - key;
                if(newIndex < 0){ // if we are at the begging of the alphabet
                    newIndex = newIndex + 26; // subtract the alphabet. Since arrays start at 0 we need to subtract 26 instead of 25
                }

                // char newLetter = alphabet[newIndex]; // The new letter
                newLetter = String.valueOf(alphabet[newIndex]); // converting the new letter from a char to a string
            }

            decryptMess = decryptMess + newLetter; // Adding the newLetter to the newMessage

            i++;
        }

        return decryptMess;
    }

    public String EncryptMessageMedium(){
        String oldMessage = message;
        String encryptMess = "";
        String keyString = "";
        int newKey = -1;

        int i = 0;
        while(i < oldMessage.length()) { // While loop until the end of the message
            int index = -1; // To know if the char is not a letter
            char letter = oldMessage.charAt(i); // Take the char of the old message, one letter at a time

            for (int k = 0; k < alphabet.length; k++) { // For loop to find the index of the char
                char tempLetter = alphabet[k];

                if (letter == tempLetter) {
                    index = k;
                }
            }
            // At this point we have the index //

            String newLetter = "";

            if(index == -1){ // If the index is still -1 then we know it is not a letter therefor it doesn't change
                newLetter = String.valueOf(letter);
                keyString = keyString + " ,"; // Add a space and then a comma
            }else{
                newKey = (int)(Math.random() * 25);
                int newIndex = index + newKey;
                if(newIndex > 25){ // if we are at the end of the alphabet
                    newIndex = newIndex - 26; // subtract the alphabet. Since arrays start at 0 we need to subtract 26 instead of 25
                }

                // char newLetter = alphabet[newIndex]; // The new letter
                newLetter = String.valueOf(alphabet[newIndex]); // converting the new letter from a char to a string
                keyString = keyString + Integer.toString(newKey) + ",";
            }

            encryptMess = encryptMess + newLetter; // Adding the newLetter to the newMessage

            i++;
        }

        setKeyList(keyString);
        return encryptMess;
    }

    public String DecryptMessageMedium(){
        String encryptMess = message;
        String decryptMess = "";

        String keylist = this.keyList;

        int i = 0;
        while(i < encryptMess.length()){
            int index = -1; // To know if the char is not a letter
            char letter = encryptMess.charAt(i); // Take the char of the old message, one letter at a time

            for (int k = 0; k < alphabet.length; k++){ // For loop to find the index of the char
                char tempLetter = alphabet[k];

                if(letter == tempLetter){
                    index = k;
                }
            }

            // At this point we have the index //

            String newLetter = "";

            String[] hold = keylist.split("[,]",0); // Takes the string of numbers and splits it by commas and puts it in an array


            if(index == -1){ // If the index is still -1 then we know it is not a letter therefor it doesn't change
                newLetter = String.valueOf(letter);
            }else{
                int numberkey = Integer.parseInt(hold[i]); // changes the string to an integer
                int newIndex = index - numberkey;
                if(newIndex < 0){ // if we are at the begging of the alphabet
                    newIndex = newIndex + 26; // subtract the alphabet. Since arrays start at 0 we need to subtract 26 instead of 25
                }

                // char newLetter = alphabet[newIndex]; // The new letter
                newLetter = String.valueOf(alphabet[newIndex]); // converting the new letter from a char to a string
            }

            decryptMess = decryptMess + newLetter; // Adding the newLetter to the newMessage

            i++;
        }

        return decryptMess;
    }
    public static void printMessage(String Nmessage){ // This method prints out a string with spaces between each letter

        for (int i = 0; i < Nmessage.length(); i++) {
           System.out.print(Nmessage.charAt(i) + " ");
        }
        System.out.println();
    }

    public void printKey(){ // This method prints out a string with spaces between each letter

        String[] newStr = keyList.split("[,]",0);

        for (int i = 0; i < newStr.length; i++) {
            System.out.print(newStr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        OneTimePad myObj = new OneTimePad();

        System.out.println("Please enter your message!");
        Scanner input = new Scanner(System.in);

        String message = input.nextLine();
        myObj.setMessage(message);


        System.out.print("Message:     ");
        myObj.printMessage(message);

        String newMessage = myObj.EncryptMessageMedium();

        System.out.print("Key:         ");
        myObj.printKey();

        System.out.print("Cipher Text: ");
        myObj.printMessage(newMessage);


        myObj.setMessage(newMessage);
        String deMessage = myObj.DecryptMessageMedium();

        System.out.print("Decrypt Text: ");
        myObj.printMessage(deMessage);


//        System.out.println("Please enter your key!");
//        input = new Scanner(System.in);
//        int key = input.nextInt();
//        myObj.setKey(key);
//
//        System.out.println("Encrypting Message");
//        System.out.println(myObj.getMessage());
//        System.out.println(myObj.EncryptMessage());
//
//        myObj.setMessage(myObj.EncryptMessage());
//
//        System.out.println("Decrypting Message");
//        System.out.println(myObj.getMessage());
//        System.out.println(myObj.DecryptMessage());

//        System.out.println(myObj.getMessage());
//
//        myObj.setMessage(myObj.EncryptMessageMedium());
//        String newMessage = myObj.getMessage();
//
//        System.out.println(newMessage);
//        System.out.println(myObj.getKeyList());
//
//
//        System.out.println(myObj.DecryptMessageMedium());

//        String str = myObj.getKeyList();
//        System.out.println("Message length = " + message.length());
//        System.out.println("Length key = "+ str.length());
//        String[] newStr = str.split("[,]",0);
//        System.out.println("Length of newStr = " + newStr.length);
//        for (int i = 0; i < newStr.length; i++) {
//            System.out.print(newStr[i] + " ");
//        }



    }
}
