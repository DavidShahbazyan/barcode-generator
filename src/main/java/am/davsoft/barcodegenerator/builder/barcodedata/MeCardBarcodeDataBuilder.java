package am.davsoft.barcodegenerator.builder.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.MeCardBarcodeData;
import am.davsoft.barcodegenerator.builder.SimpleDataBuilder;
import am.davsoft.barcodegenerator.impl.barcodedata.MeCardBarcodeDataImpl;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class MeCardBarcodeDataBuilder implements SimpleDataBuilder<MeCardBarcodeData> {
    private String name;
    private String company;
    private String phone;
    private String website;
    private String email;
    private String address;
    private String note;

    @Override
    public MeCardBarcodeData build() {
        return new MeCardBarcodeDataImpl(this.name, this.company, this.phone, this.website, this.email, this.address, this.note);
    }

    public MeCardBarcodeDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MeCardBarcodeDataBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public MeCardBarcodeDataBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public MeCardBarcodeDataBuilder withWebsite(String website) {
        this.website = website;
        return this;
    }

    public MeCardBarcodeDataBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public MeCardBarcodeDataBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public MeCardBarcodeDataBuilder withNote(String note) {
        this.note = note;
        return this;
    }
}
