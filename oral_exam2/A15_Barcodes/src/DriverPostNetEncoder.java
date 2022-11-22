// DriverPostNetEncoder by Fatima Kammona
/* This is the driver class for the PostNetEncoder program. It asks for the zip and then displays the barcode. */

import java.util.Scanner; // So that I write to the screen

public class DriverPostNetEncoder {
    public static void main(String[] args) {
        PostNetEncoder postNET = new PostNetEncoder();
        System.out.print("Enter Zip: ");

        Scanner inputZip = new Scanner(System.in);
        String zip = inputZip.nextLine();

        String binary = postNET.convertToBinary(postNET.checkSum(zip));
        System.out.println(postNET.createBarCode(binary));
        System.out.println(binary);
    }
}
