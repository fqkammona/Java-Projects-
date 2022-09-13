import java.lang.Math; //importing this class so i can use math.Random

public class KeyGenerator {

    /* This method generates the key */
    public static String createKeyList(int nValues){
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
