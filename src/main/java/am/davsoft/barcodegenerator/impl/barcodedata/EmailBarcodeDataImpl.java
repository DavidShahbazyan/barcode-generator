package am.davsoft.barcodegenerator.impl.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.EmailBarcodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class EmailBarcodeDataImpl implements EmailBarcodeData {
    private String email;

    public EmailBarcodeDataImpl() {
    }

    public EmailBarcodeDataImpl(String email) {
        this.email = email;
    }

    @Override
    public String getDataString() {
        return String.format("mailto:%s", email);
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
}
