/** This class decodes the UPC-A barcode.*/
public class UPCAdecoder {
    public static final String[] leftSideOdd = {"0001101", "0011001", "0010011", "0111101",
            "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
    public static final String[] rightSide = {"1110010", "1100110", "1101100", "1000010",
            "1011100", "1001110", "1010000", "1000100", "1001000", "1110100"};

    public String barcodeToProductCode(String barcode){
        return getProductCode(convertToProductCode(barcode));
    }

    public int convertNumLeft(String number, int i){
        if(leftSideOdd[i].compareTo(number) == 0){
            return i;
        } else{
            return convertNumLeft(number, (i + 1));
        }
    }

    private int convertNumRight(String number, int i){
        if(rightSide[i].compareTo(number) == 0){
            return i;
        } else{
            return convertNumRight(number, (i + 1));
        }
    }
    public int convertBinaryToNum(String number, int place){
        if(place < 6){ // leftSide
            return convertNumLeft(number,0);
        } else { // rightSide
            return convertNumRight(number,0);
        }
    }
    public String convertToProductCode(String barcode){
        StringBuilder zipCode = new StringBuilder();

        int i = 3;
        int count = 0;
        String num;
        while(i < barcode.length() - 3){
            if (count == 6){ // if we are in the middle ignore the five bit binary code
                i += 5;
            }
            num = barcode.substring(i,i+7);
            zipCode.append(convertBinaryToNum(num,count));
            i += 7;
            count ++;
        }

        return zipCode.toString();
    }

    public String getProductCode(String zip){
        return zip.substring(0,zip.length()-1);
    }

    public String getCheckDigit(String zip){
        return zip.substring(zip.length()-1);
    }
}
