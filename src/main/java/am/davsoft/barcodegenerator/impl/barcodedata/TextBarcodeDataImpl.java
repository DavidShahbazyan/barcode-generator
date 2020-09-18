package am.davsoft.barcodegenerator.impl.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.TextBarcodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class TextBarcodeDataImpl implements TextBarcodeData {
    private String text;

    public TextBarcodeDataImpl() {
    }

    public TextBarcodeDataImpl(String text) {
        this.text = text;
    }

    @Override
    public String getDataString() {
        return text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
