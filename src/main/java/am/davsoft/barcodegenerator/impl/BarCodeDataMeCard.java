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

    private BarCodeDataMeCard() { }

    public static BarCodeDataMeCard newInstance() {
        return new BarCodeDataMeCard();
    }

    public BarCodeDataMeCard withName(String name) {
        this.name = name;
        return this;
    }

    public BarCodeDataMeCard withCompany(String company) {
        this.company = company;
        return this;
    }

    public BarCodeDataMeCard withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public BarCodeDataMeCard withWebsite(String website) {
        this.website = website;
        return this;
    }

    public BarCodeDataMeCard withEmail(String email) {
        this.email = email;
        return this;
    }

    public BarCodeDataMeCard withAddress(String address) {
        this.address = address;
        return this;
    }

    public BarCodeDataMeCard withNote(String note) {
        this.note = note;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String getDataString() {
        return String.format("MECARD:N:%s;ORG:%s;TEL:%s;URL:%s;EMAIL:%s;ADR:%s;NOTE:%s;;", name, company, phone, website, email, address, note);
    }
}
