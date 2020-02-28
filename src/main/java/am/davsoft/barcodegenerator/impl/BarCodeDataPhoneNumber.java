package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataPhoneNumber implements BarCodeData {
    private String phone;

    private BarCodeDataPhoneNumber() { }

    public static BarCodeDataPhoneNumber newInstance() {
        return new BarCodeDataPhoneNumber();
    }

    public BarCodeDataPhoneNumber withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String getDataString() {
        return String.format("tel:%s", phone);
    }
}
