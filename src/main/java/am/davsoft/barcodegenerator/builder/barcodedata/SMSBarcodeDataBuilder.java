package am.davsoft.barcodegenerator.builder.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.SMSBarcodeData;
import am.davsoft.barcodegenerator.builder.SimpleDataBuilder;
import am.davsoft.barcodegenerator.impl.barcodedata.SMSBarcodeDataImpl;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class SMSBarcodeDataBuilder implements SimpleDataBuilder<SMSBarcodeData> {
    private String phone;
    private String message;

    @Override
    public SMSBarcodeData build() {
        return new SMSBarcodeDataImpl(this.phone, this.message);
    }

    public SMSBarcodeDataBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public SMSBarcodeDataBuilder withMessage(String message) {
        this.message = message;
        return this;
    }
}
