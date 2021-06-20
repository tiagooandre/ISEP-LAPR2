package app.domain.model;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;

public interface ExternalModuleBarcode {
    public String generateBarcode() throws BarcodeException, IOException, OutputException;
}
