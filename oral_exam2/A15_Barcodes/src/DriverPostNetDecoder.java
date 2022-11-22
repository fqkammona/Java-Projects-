// DriverPostNetDecoder by Fatima Kammona
/* This is the driver class for the PostNetDecoder program. It asks for the barcode and then displays the zip. */

import java.util.Scanner; // So that I write to the screen

public class DriverPostNetDecoder {
    public static void main(String[] args) {
        PostNetDecoder postNET = new PostNetDecoder();
        System.out.print("Enter Barcode: ");

        Scanner inputBarcode = new Scanner(System.in);
        String zip = inputBarcode.nextLine();

        System.out.println(postNET.convertBarcode(zip));
    }
}
