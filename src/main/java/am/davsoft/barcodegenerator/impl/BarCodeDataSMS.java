package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataSMS implements BarCodeData {
    private String phone;
    private String message;

    private BarCodeDataSMS() { }

    public static BarCodeDataSMS newInstance() {
        return new BarCodeDataSMS();
    }

    public BarCodeDataSMS withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public BarCodeDataSMS withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String getDataString() {
        return String.format("smsto:%s:%s", phone, message);
    }
}
