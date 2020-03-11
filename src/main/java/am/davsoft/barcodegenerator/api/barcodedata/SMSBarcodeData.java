package am.davsoft.barcodegenerator.api.barcodedata;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public interface SMSBarcodeData extends BarcodeData {
    String getPhone();

    void setPhone(String phone);

    String getMessage();

    void setMessage(String message);
}
