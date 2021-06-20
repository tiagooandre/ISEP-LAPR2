package app.domain.model;

import java.io.Serializable;

public class Sample implements Serializable {

    /**
     * The sample's barcode
     */
    private String numberBarcode;

    /**
     * Creates an instance of sample
     *
     * @param numberBarcode The barcode of this sample
     */
    public Sample(String numberBarcode){
        this.numberBarcode = numberBarcode;
    }

    /**
     * Gets this sample's barcode
     *
     * @return The barcode
     */
    public String getBarcode(){
        return this.numberBarcode;
    }
}
