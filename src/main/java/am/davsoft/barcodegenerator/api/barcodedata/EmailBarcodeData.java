package am.davsoft.barcodegenerator.api.barcodedata;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public interface EmailBarcodeData extends BarcodeData {
    String getEmail();

    void setEmail(String email);
}
