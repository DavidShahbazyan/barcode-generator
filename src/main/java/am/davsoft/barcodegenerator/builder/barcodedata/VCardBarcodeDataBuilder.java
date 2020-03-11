package am.davsoft.barcodegenerator.builder.barcodedata;

import am.davsoft.barcodegenerator.api.ContactName;
import am.davsoft.barcodegenerator.api.PhoneNumber;
import am.davsoft.barcodegenerator.api.barcodedata.VCardBarcodeData;
import am.davsoft.barcodegenerator.builder.SimpleDataBuilder;
import am.davsoft.barcodegenerator.impl.barcodedata.VCardBarcodeDataImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * <b>VCard in Wiki:</b> https://ru.wikipedia.org/wiki/VCard
 *
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class VCardBarcodeDataBuilder implements SimpleDataBuilder<VCardBarcodeData> {
    private ContactName contactName;
    private String company;
    private String title;
    private List<PhoneNumber> phoneNumbers = new LinkedList<>();
    private String website;
    private String email;
    private String address;
    private String note;

    @Override
    public VCardBarcodeData build() {
        VCardBarcodeData data = new VCardBarcodeDataImpl();
        data.setContactName(this.contactName);
        data.setCompany(this.company);
        data.setTitle(this.title);
        data.setPhoneNumbers(this.phoneNumbers);
        data.setWebsite(this.website);
        data.setEmail(this.email);
        data.setAddress(this.address);
        data.setNote(this.note);
        return data;
    }

    public VCardBarcodeDataBuilder withContactName(ContactName contactName) {
        this.contactName = contactName;
        return this;
    }

    public VCardBarcodeDataBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public VCardBarcodeDataBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public VCardBarcodeDataBuilder withPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
        return this;
    }

    public VCardBarcodeDataBuilder withPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers.addAll(phoneNumbers);
        return this;
    }

    public VCardBarcodeDataBuilder withWebsite(String website) {
        this.website = website;
        return this;
    }

    public VCardBarcodeDataBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public VCardBarcodeDataBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public VCardBarcodeDataBuilder withNote(String note) {
        this.note = note;
        return this;
    }
}
