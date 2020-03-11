package am.davsoft.barcodegenerator.impl.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.BarcodeData;
import am.davsoft.barcodegenerator.api.barcodedata.MeCardBarcodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class MeCardBarcodeDataImpl implements MeCardBarcodeData {
    private String name;
    private String company;
    private String phone;
    private String website;
    private String email;
    private String address;
    private String note;

    @Override
    public String getDataString() {
        return String.format("MECARD:N:%s;ORG:%s;TEL:%s;URL:%s;EMAIL:%s;ADR:%s;NOTE:%s;;", name, company, phone, website, email, address, note);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCompany() {
        return company;
    }

    @Override
    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getWebsite() {
        return website;
    }

    @Override
    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getNote() {
        return note;
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }
}
