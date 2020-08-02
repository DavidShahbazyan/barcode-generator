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
    public PhoneNumberBarcodeData buildData() {
        PhoneNumberBarcodeData data = new PhoneNumberBarcodeDataImpl();
        data.setPhone(this.phone);
        return data;
    }

    @Override
    public void reset() {
        this.phone = null;
    }

    public PhoneNumberBarcodeDataBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
