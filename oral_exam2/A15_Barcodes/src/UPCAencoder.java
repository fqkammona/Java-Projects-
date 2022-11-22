// UPCAencoder.java by Fatima Kammona
// This class encodes the UPC-A barcode.
public class UPCAencoder {
    public static final String[] leftSideOdd = {"0001101", "0011001", "0010011", "0111101",
            "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
    public static final String[] rightSide = {"1110010", "1100110", "1101100", "1000010",
            "1011100", "1001110", "1010000", "1000100", "1001000", "1110100"};

    /**
     * Given the product code this method calls the checkDigit method and then uses the number returned to call
     * the createBarcode and returns the barcode made.
     */
    public String productCodeToBarcode(String productCode) {
        return createBarcode(checkDigit(productCode));
    }

    /**
     * This method uses the checkSum method from the PostNetEncoder class.
     */
    public String checkDigit(String productCode) {
        PostNetEncoder post = new PostNetEncoder();
        return post.checkSum(productCode);
    }

    /**
     * This method uses if statements to find the correct product num to return.
     */
    public String convertProductNum(int number, int i, int productCodeLength) {
        if (i < productCodeLength / 2) { // leftSide
            return leftSideOdd[number];
        } else if (i > productCodeLength / 2) { // rightSide
            return rightSide[number];
        } else { // middle
            return "01010" + rightSide[number];
        }
    }

    /**
     * Takes in a string of numbers and uses the convertProductNum to convert the numbers to the corresponding
     * binary representation.
     */
    public String createBarcode(String productCode) {
        StringBuilder barCode = new StringBuilder("101");

        int i = 0;
        while (i < productCode.length()) {
            int hold = Integer.parseInt(String.valueOf(productCode.charAt(i))); // string 1234 - char 1 - string 1 - int 1
            barCode.append(convertProductNum(hold, i, productCode.length()));
            i++;
        }
        return barCode + "101";
    }
}
