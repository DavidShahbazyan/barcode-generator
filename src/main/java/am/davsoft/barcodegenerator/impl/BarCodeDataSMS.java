package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataSMS implements BarCodeData {
    private String phone;
    private String message;

    public BarCodeDataSMS setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public BarCodeDataSMS setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String getData() {
        return String.format("smsto:%s:%s", phone, message);
    }
}
