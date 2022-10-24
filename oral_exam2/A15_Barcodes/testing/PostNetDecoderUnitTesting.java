/** This is the unit testing class for the POSTNETDECODER class.*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PostNetDecoderUnitTesting {

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"010100010100101010010010101010,|.|.|...|.|..|.|.|..|..|.|.|.|.|"})
    void barCodeTesting(String input, String output){
        PostNetDecoder b = new PostNetDecoder();
        assertEquals(b.convertBarcodeToBinary(output), input);
    }
}
