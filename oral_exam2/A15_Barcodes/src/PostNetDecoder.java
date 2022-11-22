// PostNetDecoder.java by Fatima Kammona
// This class decodes the POSTNET barcode

public class PostNetDecoder {
    public static final String[] postNetCode = {"11000", "00011", "00101", "00110",
            "01001", "01010", "01100", "10001", "10010", "10100"};
    private String checkSum;
    private String zip;

    /**
     * This method takes a barcode and does all the appropriate converting to return the original zip.
     * First. Converts the barcode to binary code using the convertBarcodeToBinary method
     * Second. Converts binary code into the zip using the convertFromBinary method
     * Third. The convertFromBinary method calls the setInstanceVariables
     * Fourth. When calling the getZip, the final method called convertToOriginalZip is called and sends back the
     * correct format for the zip.
     */
    public String convertBarcode(String barCode) {
        convertFromBinary(convertBarcodeToBinary(barCode));
        return getZip();
    }

    /**
     * This method uses Java Regex to return the zip to the original format
     */
    public String convertToOriginalZip(String zip) {
        if (zip.matches("\\d{9}")) {
            return zip.replaceFirst("(\\d{5})(\\d{4})", "$1-$2");
        } else if (zip.matches("\\d{11}")) {
            return zip.replaceFirst("(\\d{5})(\\d{4})(\\d+)", "$1-$2-$3");
        } else {
            return zip;
        }
    }

    /**
     * Takes a string of a barcode and converts it into a string of binary and returns the barCode
     */
    public String convertBarcodeToBinary(String barcode) {
        StringBuilder binaryString = new StringBuilder();

        int i = 1;
        while (i < barcode.length() - 1) {
            if (barcode.charAt(i) == '|') {
                binaryString.append("1");
            } else {
                binaryString.append("0");
            }
            i++;
        }
        return binaryString.toString();
    }

    /**
     * This method takes a string of binary numbers and converts it back to the zip. To convert
     * the binary code the recursive algorithm convertNumber is called.
     */
    public void convertFromBinary(String binary) {
        StringBuilder zipCode = new StringBuilder();

        int i = 0;
        while (i < binary.length()) {
            String num = binary.substring(i, i + 5);
            zipCode.append(convertNumber(num, 0));
            i += 5;
        }

        setInstanceVariables(zipCode.toString());
    }

    /**
     * This method takes a string that has the original zip and checksum
     * and uses substring to fill the static variables checkSum and zip.
     */
    private void setInstanceVariables(String zipCode) {
        checkSum = zipCode.substring(zipCode.length() - 1);
        zip = zipCode.substring(0, zipCode.length() - 1);
    }

    public String getChecksum() {
        return checkSum;
    }

    public String getZip() {
        zip = convertToOriginalZip(zip);
        return zip;
    }

    /**
     * A recursive algorithm that searches through the postnetcode to find
     * the number that matches the binary string given.
     */
    public int convertNumber(String number, int i) {
        if (postNetCode[i].compareTo(number) == 0) {
            return i;
        } else {
            return convertNumber(number, (i + 1));
        }
    }
}
