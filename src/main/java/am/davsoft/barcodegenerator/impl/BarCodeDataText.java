package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataText implements BarCodeData {
    private String text;

    public BarCodeDataText setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public String getData() {
        return text;
    }
}
