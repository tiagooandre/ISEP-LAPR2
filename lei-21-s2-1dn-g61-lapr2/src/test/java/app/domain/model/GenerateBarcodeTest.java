package app.domain.model;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GenerateBarcodeTest{

    /**
     * Test of getNumberBarcodetest method, of class GenerateBarcode.
     */
    @Test
    public void getNumberBarcodetest() {
        GenerateBarcode generateBarcode = new GenerateBarcode();
        GenerateBarcode generateBarcode2 = new GenerateBarcode();
        System.out.println("getNumberBarcode");
        String expected = generateBarcode2.getNumberBarcode();
        String result = generateBarcode.getNumberBarcode();
        assertEquals(expected,result);
    }

    /**
     * Test of generateBarcode method, of class GenerateBarcode.
     */
    @Test
    public void generateBarcode2() throws BarcodeException, IOException, OutputException {
        GenerateBarcode generateBarcode = new GenerateBarcode();
        String str_barcode = "10000000000";

        assertEquals(str_barcode, generateBarcode.generateBarcode());
    }

}