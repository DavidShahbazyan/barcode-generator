package am.davsoft.barcodegenerator.builder.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.TextBarcodeData;
import am.davsoft.barcodegenerator.builder.SimpleDataBuilder;
import am.davsoft.barcodegenerator.impl.barcodedata.TextBarcodeDataImpl;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class TextBarcodeDataBuilder implements SimpleDataBuilder<TextBarcodeData> {
    private String text;

    @Override
    public TextBarcodeData build() {
        TextBarcodeData data = new TextBarcodeDataImpl();
        data.setText(this.text);
        return data;
    }

    public TextBarcodeDataBuilder withText(String text) {
        this.text = text;
        return this;
    }
}
