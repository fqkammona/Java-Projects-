/** This is the unit testing class for the UPCAdecoder class.*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UPCAdecoderUnitTesting {

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"012546673754,10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101"})
    void testCreateBarcode(String input, String output){
        UPCAdecoder b = new UPCAdecoder();
        assertEquals(b.convertToProductCode(output), input);
    }
}
