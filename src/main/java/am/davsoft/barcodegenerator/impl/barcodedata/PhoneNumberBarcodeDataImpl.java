package am.davsoft.barcodegenerator.impl.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.PhoneNumberBarcodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class PhoneNumberBarcodeDataImpl implements PhoneNumberBarcodeData {
    private String phone;

    public PhoneNumberBarcodeDataImpl() {
    }

    public PhoneNumberBarcodeDataImpl(String phone) {
        this.phone = phone;
    }

    @Override
    public String getDataString() {
        return String.format("tel:%s", phone);
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
