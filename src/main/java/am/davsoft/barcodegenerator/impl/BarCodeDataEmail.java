package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataEmail implements BarCodeData {
    private String email;

    public BarCodeDataEmail setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String getData() {
        return String.format("mailto:%s", email);
    }
}
