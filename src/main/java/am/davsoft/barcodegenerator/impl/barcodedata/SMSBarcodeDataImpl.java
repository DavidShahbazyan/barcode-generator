package am.davsoft.barcodegenerator.impl.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.SMSBarcodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class SMSBarcodeDataImpl implements SMSBarcodeData {
    private String phone;
    private String message;

    public SMSBarcodeDataImpl() {
    }

    public SMSBarcodeDataImpl(String phone, String message) {
        this.phone = phone;
        this.message = message;
    }

    @Override
    public String getDataString() {
        return String.format("smsto:%s:%s", phone, message);
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
