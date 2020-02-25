package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataMeCard implements BarCodeData {
    private String name;
    private String company;
    private String phone;
    private String website;
    private String email;
    private String address;
    private String note;

    public BarCodeDataMeCard setName(String name) {
        this.name = name;
        return this;
    }

    public BarCodeDataMeCard setCompany(String company) {
        this.company = company;
        return this;
    }

    public BarCodeDataMeCard setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public BarCodeDataMeCard setWebsite(String website) {
        this.website = website;
        return this;
    }

    public BarCodeDataMeCard setEmail(String email) {
        this.email = email;
        return this;
    }

    public BarCodeDataMeCard setAddress(String address) {
        this.address = address;
        return this;
    }

    public BarCodeDataMeCard setNote(String note) {
        this.note = note;
        return this;
    }

    @Override
    public String getData() {
        return String.format("MECARD:N:%s;ORG:%s;TEL:%s;URL:%s;EMAIL:%s;ADR:%s;NOTE:%s;;", name, company, phone, website, email, address, note);
    }
}
