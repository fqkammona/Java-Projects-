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
    @CsvSource({"52242,01010 00101 00101 01001 00101", "01245,11000 00011 00101 01001 01010"})
    void testBinaryConverterToLargeNum(String input, String output){
        PostNetEncoder b = new PostNetEncoder();
        assertEquals(b.convertToBinary(input), output + " ");
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

}
