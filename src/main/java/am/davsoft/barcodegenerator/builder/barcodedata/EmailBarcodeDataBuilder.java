package am.davsoft.barcodegenerator.builder.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.EmailBarcodeData;
import am.davsoft.barcodegenerator.builder.SimpleDataBuilder;
import am.davsoft.barcodegenerator.impl.barcodedata.EmailBarcodeDataImpl;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class EmailBarcodeDataBuilder implements SimpleDataBuilder<EmailBarcodeData> {
    private String email;

    @Override
    public EmailBarcodeData build() {
        return new EmailBarcodeDataImpl(this.email);
    }

    public EmailBarcodeDataBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
}
