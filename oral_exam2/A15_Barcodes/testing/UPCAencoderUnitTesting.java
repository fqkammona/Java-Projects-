/** This is the unit testing class for the UPCAencoder class.*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UPCAencoderUnitTesting {

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"01254667375,012546673754"})
    void checkDigitTesting(String input, String output){
        UPCAencoder b = new UPCAencoder();
        assertEquals(b.checkDigit(input), output);
    }

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"012546673754,10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101"})
    void testCreateBarcode(String input, String output){
        UPCAencoder b = new UPCAencoder();
        assertEquals(b.createBarcode(input), output);
    }

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"01254667375,10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101"})
    void productToBarcodeTest(String input, String output){
        UPCAencoder b = new UPCAencoder();
        assertEquals(b.productCodeToBarcode(input), output);
    }
}
