/** This class encodes the POSTNET barcode.*/
public class PostNetEncoder {

    public static final String[] postNetCode = {"11000", "00011", "00101", "00110",
            "01001", "01010", "01100", "10001", "10010", "10100"};

    /** Returns the POSTNET code for a given number.*/
    public String convertToBinary(int num){
        return postNetCode[num];
    }

    /** Method that prints out the Binary Representation for the digits 0-9.*/
    public String listOfPostNetCode(){
        String list = "";

        for(int i = 0; i < postNetCode.length; i++){
            list += "Digit: "+ i + "\tBinary Representation: " + postNetCode[i] + "\n";
        }

        return list;
    }
}
