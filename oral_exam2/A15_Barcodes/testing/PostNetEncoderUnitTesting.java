/** This is the unit testing class for the POSTNET class.*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PostNetEncoderUnitTesting {

    /** This method test the binary converter */
    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"5,01010", "0,11000 ", "9,10100 " })
     void testBinaryConverter(int input, String output){
         PostNetEncoder b = new PostNetEncoder();
         assertEquals(b.convertNumToBinary(input), output);
     }

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"52242,0101000101001010100100101", "01245,1100000011001010100101010"})
    void testBinaryConverterToLargeNum(String input, String output){
        PostNetEncoder b = new PostNetEncoder();
        assertEquals(b.convertToBinary(input), output);
    }

    @Test
    void printListOfCodes(){
        PostNetEncoder b = new PostNetEncoder();
        assertEquals(b.listOfPostNetCode(), "Digit: 0\tBinary Representation: 11000\n" +
                "Digit: 1\tBinary Representation: 00011\n" +
                "Digit: 2\tBinary Representation: 00101\n" +
                "Digit: 3\tBinary Representation: 00110\n" +
                "Digit: 4\tBinary Representation: 01001\n" +
                "Digit: 5\tBinary Representation: 01010\n" +
                "Digit: 6\tBinary Representation: 01100\n" +
                "Digit: 7\tBinary Representation: 10001\n" +
                "Digit: 8\tBinary Representation: 10010\n" +
                "Digit: 9\tBinary Representation: 10100\n");
    }

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"21,9", "30,0", "19,1"})
    void testnextDivisableNum(double input, int output){
        PostNetEncoder b = new PostNetEncoder();
        assertEquals(b.nextDividableNum(input,0), output);
    }

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"52242,522425"})
    void checkingSum(String input, String output){
        PostNetEncoder b = new PostNetEncoder();
        assertEquals(b.checkSum(input), output);
    }

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"010100010100101010010010101010 ,|.|.|...|.|..|.|.|..|..|.|.|.|.|"})
    void barCodeTesting(String input, String output){
        PostNetEncoder b = new PostNetEncoder();
        assertEquals(b.createBarCode(input), output);
    }

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"52242 ,|.|.|...|.|..|.|.|..|..|.|.|.|.|"})
    void zipToBarcode(String input, String output){
        PostNetEncoder b = new PostNetEncoder();
        assertEquals(b.convertZip(input), output);
    }

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"52242,52242", "52242-1234,522421234", "52242-1234-12,52242123412","123456789, Error: Input not valid."})
    void checkingDifferentZips(String input, String output){
        PostNetEncoder b = new PostNetEncoder();
        assertEquals(b.convertAnyZip(input), output);
    }
}
