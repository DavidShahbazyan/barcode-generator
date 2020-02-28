package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataText implements BarCodeData {
    private String text;

    private BarCodeDataText() { }

    public static BarCodeDataText newInstance() {
        return new BarCodeDataText();
    }

    public BarCodeDataText withText(String text) {
        this.text = text;
        return this;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getDataString() {
        return text;
    }
}
