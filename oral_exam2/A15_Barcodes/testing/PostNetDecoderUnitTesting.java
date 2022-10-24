/** This is the unit testing class for the POSTNETDECODER class.*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PostNetDecoderUnitTesting {

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"|.|.|...|.|..|.|.|..|..|.|.|.|.|, 010100010100101010010010101010"})
    void barCodeTesting(String input, String output){
        PostNetDecoder b = new PostNetDecoder();
        assertEquals(b.convertBarcodeToBinary(input), output);
    }

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"010100010100101010010010101010, 522425"})
    void binaryToZipTesting(String input, String output){
        PostNetDecoder b = new PostNetDecoder();
        assertEquals(b.convertFromBinary(input), output);
    }

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"01010, 5", "11000, 0", "10100, 9" })
    void testNumConverter(String input, int output){
        PostNetDecoder b = new PostNetDecoder();
        assertEquals(b.convertNumber(input,0), output);
    }

    @Test
    void checkSumTesting(){
        PostNetDecoder b = new PostNetDecoder();
        b.convertFromBinary("010100010100101010010010101010");
        assertEquals(b.getChecksum(),"5");
        assertEquals(b.getZip(),"52242");
    }

    @Test
    void barcodeToZipTesting(){
        PostNetDecoder b = new PostNetDecoder();
        assertEquals(b.convertBarcode("|.|.|...|.|..|.|.|..|..|.|.|.|.|"),"52242");
    }
}
