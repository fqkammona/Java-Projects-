// DriverUPCAencoder by Fatima Kammona
/*
 * This is the driver class for the UPCA encoder program. It asks for the product code and then displays
 * the barcode.
 */

import java.util.Scanner; // So that I write to the screen

public class DriverUPCAencoder {
    public static void main(String[] args) {
        UPCAencoder upcaEncoder = new UPCAencoder();
        System.out.print("Enter product code: ");

        Scanner productCode = new Scanner(System.in);
        String product = productCode.nextLine();

        System.out.println(upcaEncoder.productCodeToBarcode(product));
    }
}
