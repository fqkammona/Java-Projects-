/* KeyGenerator by Fatima Kammona */

/** This class takes in an int value and then uses Math.random
 * to generate a string of random integers ......... FINISH THIS
 * */

import java.lang.Math; //importing this class so i can use math.Random

public class KeyGenerator {

    /* This method generates the key */
     String createKeyList(int nValues){
        int i = 1;
        String keyList = "";

        while(i <= nValues){
            int newKey = (int)(Math.random() * 25);
            keyList = keyList + newKey + ",";

            i++;
        }
        return keyList;
    }
}
