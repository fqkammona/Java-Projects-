/** This is the unit testing class for the POSTNET class.*/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostNetEncoderUnitTesting {
     @Test
     void testBinaryConverter(){
         PostNetEncoder b = new PostNetEncoder();
         assertEquals(b.convertToBinary(5), "01010");
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
