/** This is the unit testing class for the UPCAdecoder class.*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UPCAdecoderUnitTesting {

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101, 4, 01254667375"})
    void testCreateBarcode(String barcode, String checkdigit, String productCode){
        UPCAdecoder b = new UPCAdecoder(barcode);
        assertEquals(b.getProductCode(), productCode);
        assertEquals(b.getCheckDigit(), checkdigit);
    }
}
