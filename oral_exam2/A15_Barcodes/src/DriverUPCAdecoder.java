// DriverUPCAdecoder by Fatima Kammona
/*
 * This is the driver class for the UPCA decoder program. It asks for the barcode and prints out the check digit
 * and product code.
 */

import java.util.Scanner; // So that I write to the screen

public class DriverUPCAdecoder {
    public static void main(String[] args) {
        System.out.print("Enter Barcode to decode: ");

        Scanner inputBarcode = new Scanner(System.in);
        UPCAdecoder postNET = new UPCAdecoder(inputBarcode.nextLine());

        System.out.println("Check Digit: " + postNET.getCheckDigit());
        System.out.println("Product code: " + postNET.getProductCode());
    }
}

