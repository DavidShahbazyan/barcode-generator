package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataPhoneNumber implements BarCodeData {
    private String phone;

    public BarCodeDataPhoneNumber setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String getData() {
        return String.format("tel:%s", phone);
    }
}
