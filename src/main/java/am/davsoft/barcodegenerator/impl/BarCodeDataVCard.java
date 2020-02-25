package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;
import am.davsoft.barcodegenerator.model.ContactName;
import am.davsoft.barcodegenerator.model.PhoneNumber;

import java.util.LinkedList;
import java.util.List;

/**
 * <b>VCard in Wiki:</b> https://ru.wikipedia.org/wiki/VCard
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataVCard implements BarCodeData {
    private ContactName contactName;
    private String company;
    private String title;
    private List<PhoneNumber> phoneNumbers = new LinkedList<>();
    private String website;
    private String email;
    private String address;
    private String note;

    public BarCodeDataVCard setContactName(ContactName contactName) {
        this.contactName = contactName;
        return this;
    }

    public BarCodeDataVCard setCompany(String company) {
        this.company = company;
        return this;
    }

    public BarCodeDataVCard setTitle(String title) {
        this.title = title;
        return this;
    }

    public BarCodeDataVCard addPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
        return this;
    }

    public BarCodeDataVCard addAllPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers.addAll(phoneNumbers);
        return this;
    }

    public BarCodeDataVCard setWebsite(String website) {
        this.website = website;
        return this;
    }

    public BarCodeDataVCard setEmail(String email) {
        this.email = email;
        return this;
    }

    public BarCodeDataVCard setAddress(String address) {
        this.address = address;
        return this;
    }

    public BarCodeDataVCard setNote(String note) {
        this.note = note;
        return this;
    }

    @Override
    public String getData() {
        StringBuilder builder = new StringBuilder("BEGIN:VCARD").append('\n').append("VERSION:3.0");
        if (contactName != null) {
            builder.append('\n').append("N:").append(contactName);
        }
        if (company != null) {
            builder.append('\n').append("ORG:").append(company);
        }
        if (title != null) {
            builder.append('\n').append("TITLE:").append(title);
        }
        if (phoneNumbers != null && !phoneNumbers.isEmpty()) {
            phoneNumbers.forEach(number -> builder.append('\n').append("TEL").append(number.toDataString()));
        }
        if (website != null) {
            builder.append('\n').append("URL:").append(website);
        }
        if (email != null) {
            builder.append('\n').append("EMAIL:").append(email);
        }
        if (address != null) {
            builder.append('\n').append("ADR:").append(address);
        }
        if (note != null) {
            builder.append('\n').append("NOTE:").append(note);
        }
        builder.append('\n').append("END:VCARD");
        return builder.toString();
    }
}
