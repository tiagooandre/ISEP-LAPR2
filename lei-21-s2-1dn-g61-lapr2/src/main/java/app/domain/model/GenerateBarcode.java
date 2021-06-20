package app.domain.model;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import java.io.File;
import java.io.IOException;

public class GenerateBarcode implements ExternalModuleBarcode {

    /**
     * the number of the client
     */
    private static int numberBarcode = 0;
    /**
     * the bar height of the barcode
     */
    private static final int SIZE = 100;

    /**
     * Increases a unit in the barcode number so that all barcodes have a different number
     */
    public GenerateBarcode() {
        numberBarcode++;
    }

    /**
     * @return the barcode, a string with 11 numbers
     */
    public String getNumberBarcode() {
        int length = String.valueOf(numberBarcode).length();
        StringBuilder s = new StringBuilder(String.valueOf(numberBarcode));
        for (int i = 0; i < 11-length; i++) {
            s.append("0");
        }
        return s.toString();
    }

    /**
     * Generates an file jpeg with an barcode
     * @return a string with 11 numbers, the numbers of the barcode generated
     */
    public String generateBarcode() throws BarcodeException, IOException, OutputException {
        String strBarcode = getNumberBarcode();
        Barcode barcode = BarcodeFactory.createUPCA(strBarcode);
        barcode.setPreferredBarHeight(SIZE);

        String fileName = "Sample" + numberBarcode + ".jpg";

        File imgFile = new File(fileName);
        BarcodeImageHandler.saveJPEG(barcode, imgFile);

        return strBarcode;
    }


}
