/* DriverUPCAdecoder by Fatima Kammona */

/** This is the driver class for the UPCA decoder program.*/

import java.util.Scanner; // So that I write to the screen
public class DriverUPCAdecoder {
    public static void main(String[] args) {
        System.out.print("Enter Barcode: ");

        Scanner inputBarcode = new Scanner(System.in);
        UPCAdecoder postNET = new UPCAdecoder(inputBarcode.nextLine());

        // System.out.println(postNET.convertBarcode(zip));
    }
}

