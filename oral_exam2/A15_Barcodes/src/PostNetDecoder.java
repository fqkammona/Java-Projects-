/** This class decodes the POSTNET barcode.*/

public class PostNetDecoder {
    public static final String[] postNetCode = {"11000", "00011", "00101", "00110",
            "01001", "01010", "01100", "10001", "10010", "10100"};

    /**
     * Takes a string of a barcode and converts
     * it into a string of binary and returns the barCode
     */
    public String convertBarcodeToBinary(String barcode){
        StringBuilder binaryString = new StringBuilder();

        int i = 1;
        while(i < barcode.length() - 1){
            if(barcode.charAt(i)=='|'){
               binaryString.append("1");
            } else {
                binaryString.append("0");
            }
            i++;
        }
        return binaryString.toString();
    }


}
