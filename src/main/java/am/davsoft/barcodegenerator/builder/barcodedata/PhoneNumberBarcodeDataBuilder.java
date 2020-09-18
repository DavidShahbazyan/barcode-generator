package am.davsoft.barcodegenerator.builder.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.PhoneNumberBarcodeData;
import am.davsoft.barcodegenerator.builder.SimpleDataBuilder;
import am.davsoft.barcodegenerator.impl.barcodedata.PhoneNumberBarcodeDataImpl;


/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class PhoneNumberBarcodeDataBuilder implements SimpleDataBuilder<PhoneNumberBarcodeData> {
    private String phone;

    @Override
    public PhoneNumberBarcodeData build() {
        return new PhoneNumberBarcodeDataImpl(this.phone);
    }

    public PhoneNumberBarcodeDataBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
