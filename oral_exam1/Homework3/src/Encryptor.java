/* Encryptor Program by Fatima Kammona */

/** This class takes a message, a list of keys and a position to start.
 * It then encrypts the message using the key and position and then
 * returns the message.
 * */
public class Encryptor {
    final static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private int position;
    void setPosition(int position){ this.position = position;}
    int getPosition() {
        return position;
    }
    String EncryptMessage(String keyList, String message){
        position--; // You have to sub track by one because arrays start at zero
        String[] keyArray = keyList.split(",",0); // makes an array(size 21) of strings of each element of

        StringBuilder encryptedMessage = new StringBuilder();

        int i = 0;

        while(i < message.length()){ // Loop until we have gone through the whole message

            /* This section finds the index of the letter form the alphabet */
            int index = -1; // To know if the char is not a letter
            char letter = message.charAt(i); // Take the char of the old message, one letter at a time

            int k = 0;

            /* A while loop is faster than a for loop because then once we find index we can move on */
            while(index == -1 && k < alphabet.length){ // Run time is O(n) instead of O(n^2)
                char tempLetter = alphabet[k];
                if (letter == tempLetter) {
                    index = k;
                }
                k++;
            }

            // Now we have the index i.e M = 12//

            String newLetter;

            if(index == -1){ // If the index is still -1 then we know it is not a letter therefor it doesn't change
                newLetter = String.valueOf(letter);
            }else{
                int keyIndex = Integer.parseInt(keyArray[position]); // Gets the value of n and changes it into an int
                int newIndex = index + keyIndex;

                if(newIndex > 25){ // if we are at the end of the alphabet
                    newIndex = newIndex - 26; // subtract the alphabet. Since arrays start at 0 we need to subtract 26 instead of 25
                }
                newLetter = String.valueOf(alphabet[newIndex]); // converting the new letter from a char to a string
            }

            encryptedMessage.append(newLetter); // Adding the newLetter to the newMessage

            /* This section is the logic to loop the position */
            if(position >= keyArray.length - 1) { // If we get to the end of the array of keys
                position = 0; // Change the position to the start of the array
            }else{
                position++;
            }

            i++;
        }
        setPosition(this.position + 1); // We add by one because we went back by one at the start so we need to account for it.
        return encryptedMessage.toString();
    }
}
