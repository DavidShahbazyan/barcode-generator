package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataEmail implements BarCodeData {
    private String email;

    private BarCodeDataEmail() { }

    public static BarCodeDataEmail newInstance() {
        return new BarCodeDataEmail();
    }

    public BarCodeDataEmail withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getDataString() {
        return String.format("mailto:%s", email);
    }
}
