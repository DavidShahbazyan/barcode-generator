package am.davsoft.barcodegenerator.builder.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.URLBarcodeData;
import am.davsoft.barcodegenerator.builder.SimpleDataBuilder;
import am.davsoft.barcodegenerator.impl.barcodedata.URLBarcodeDataImpl;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class URLBarcodeDataBuilder implements SimpleDataBuilder<URLBarcodeData> {
    private String url;

    @Override
    public URLBarcodeData buildData() {
        URLBarcodeData data = new URLBarcodeDataImpl();
        data.setUrl(this.url);
        return data;
    }

    @Override
    public void reset() {
        this.url = null;
    }

    public URLBarcodeDataBuilder withUrl(String url) {
        this.url = url;
        return this;
    }
}
