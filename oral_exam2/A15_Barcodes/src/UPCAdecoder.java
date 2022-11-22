// UPCAdecoder.java by Fatima Kammona
// This class decodes the UPC-A barcode.
public class UPCAdecoder {
    public static final String[] leftSideOdd = {"0001101", "0011001", "0010011", "0111101",
            "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
    public static final String[] rightSide = {"1110010", "1100110", "1101100", "1000010",
            "1011100", "1001110", "1010000", "1000100", "1001000", "1110100"};
    private String productCode;
    private String checkDigit;

    /**
     * The constructor that takes the string of barcode and calls the convertToProduct method
     */
    public UPCAdecoder(String barcode) {
        convertToProductCode(barcode);
    }

    /* Converts the number for the left side */
    public int convertNumLeft(String number, int i) {
        if (leftSideOdd[i].compareTo(number) == 0) {
            return i;
        } else {
            return convertNumLeft(number, (i + 1));
        }
    }

    /* Converts the number for the right side */
    private int convertNumRight(String number, int i) {
        if (rightSide[i].compareTo(number) == 0) {
            return i;
        } else {
            return convertNumRight(number, (i + 1));
        }
    }

    /**
     * This method takes the string of the binary code and the place where the code lies in the original barcode
     * and uses that information to call a recursive algorithm that converts the string into the original int
     */
    public int convertBinaryToNum(String number, int place) {
        if (place < 6) { // leftSide
            return convertNumLeft(number, 0);
        } else { // rightSide
            return convertNumRight(number, 0);
        }
    }

    /**
     * This method converts the barcode into the original product code by breaking up the barcode into strings
     * and converting those strings into the correct number
     */
    public void convertToProductCode(String barcode) {
        StringBuilder zipCode = new StringBuilder();

        int i = 3;
        int count = 0;
        String num;
        while (i < barcode.length() - 3) {
            if (count == 6) { // if we are in the middle ignore the five bit binary code
                i += 5;
            }
            num = barcode.substring(i, i + 7); // Creates a string of just one binary number
            zipCode.append(convertBinaryToNum(num, count));
            i += 7;
            count++;
        }

        setCheckDigit(zipCode.toString());
        setProductCode(zipCode.toString());
    }

    /**
     * These are the accessors methods for the instance variables
     */
    public void setCheckDigit(String zip) {
        checkDigit = zip.substring(zip.length() - 1);
    }

    public void setProductCode(String zip) {
        productCode = zip.substring(0, zip.length() - 1);
    }

    public String getProductCode() {
        return productCode;
    }

    public String getCheckDigit() {
        return checkDigit;
    }
}
