package am.davsoft.barcodegenerator.builder.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.GooglePlayLinkBarcodeData;
import am.davsoft.barcodegenerator.builder.SimpleDataBuilder;
import am.davsoft.barcodegenerator.impl.barcodedata.GooglePlayLinkBarcodeDataImpl;

/**
 * @author David Shahbazyan
 * @since Aug 30, 2018
 */
public class GooglePlayLinkBarcodeDataBuilder implements SimpleDataBuilder<GooglePlayLinkBarcodeData> {
    private String packageName;

    @Override
    public GooglePlayLinkBarcodeData build() {
        GooglePlayLinkBarcodeData data = new GooglePlayLinkBarcodeDataImpl();
        data.setPackageName(this.packageName);
        return data;
    }

    public GooglePlayLinkBarcodeDataBuilder withPackageName(String packageName) {
        this.packageName = packageName;
        return this;
    }
}
