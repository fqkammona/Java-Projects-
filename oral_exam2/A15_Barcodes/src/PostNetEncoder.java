/** This class encodes the POSTNET barcode.*/
public class PostNetEncoder {
    public static final String[] postNetCode = {"11000", "00011", "00101", "00110",
            "01001", "01010", "01100", "10001", "10010", "10100"};



    /** Returns the POSTNET code for a given number.*/
    public String convertNumToBinary(int num){
       return postNetCode[num];
    }

    /** Returns the whole string for a whole number
     * That takes a string of input numbers and class
     * convertNumToBinary to return a whole string of binary inputs. */
    public String convertToBinary(String num){
        StringBuilder binaryNum = new StringBuilder();
        int i =0;
        while(i < num.length()){
            int hold = Integer.parseInt(String.valueOf(num.charAt(i))); // string 1234 - char 1 - string 1 - int 1
            binaryNum.append(convertNumToBinary(hold)).append(" ");
            i++;
        }
        return binaryNum.toString();
    }

//    public void convertStringToNum(String num){
//
//    }

    /** A recursive algorithm that finds the next number dividable by 10
     * and returns it.*/
    public int nextDivisableNum(double number, int i){
        if((number + i)%10==0){
            return i;
        } else{
            return nextDivisableNum(number, (i + 1));
        }
    }
    public int checkSum(String num){
        double sum = 0;
        int i =0;
        int holding = -1;
        while(i < num.length()) {
            int hold = Integer.parseInt(String.valueOf(num.charAt(i))); // string 1234 - char 1 - string 1 - int 1
            sum += hold;
        }

        holding = nextDivisableNum(sum,0);

        return holding;
    }

    /** Method that prints out the Binary Representation for the digits 0-9.*/
    public String listOfPostNetCode(){
        StringBuilder list = new StringBuilder();

        for(int i = 0; i < postNetCode.length; i++){
            list.append("Digit: ").append(i).append("\tBinary Representation: ").append(postNetCode[i]).append("\n");
        }

        return list.toString();
    }
}
