package am.davsoft.barcodegenerator.impl.barcodedata;

import am.davsoft.barcodegenerator.api.ContactName;
import am.davsoft.barcodegenerator.api.PhoneNumber;
import am.davsoft.barcodegenerator.api.barcodedata.VCardBarcodeData;
import am.davsoft.barcodegenerator.impl.ContactNameImpl;
import am.davsoft.barcodegenerator.impl.PhoneNumberImpl;

import java.util.List;

/**
 * <b>VCard in Wiki:</b> https://ru.wikipedia.org/wiki/VCard
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class VCardBarcodeDataImpl implements VCardBarcodeData {
    private ContactName contactName;
    private String company;
    private String title;
    private List<PhoneNumber> phoneNumbers;
    private String website;
    private String email;
    private String address;
    private String note;

    public VCardBarcodeDataImpl() {
    }

    public VCardBarcodeDataImpl(ContactName contactName, String company, String title, List<PhoneNumber> phoneNumbers, String website, String email, String address, String note) {
        this.contactName = contactName;
        this.company = company;
        this.title = title;
        this.phoneNumbers = phoneNumbers;
        this.website = website;
        this.email = email;
        this.address = address;
        this.note = note;
    }

    @Override
    public String getDataString() {
        StringBuilder builder = new StringBuilder("BEGIN:VCARD").append('\n').append("VERSION:3.0");
        if (contactName != null) {
            builder.append('\n').append("N:").append(String.join(";",
                    contactName.getLastName(), contactName.getFirstName(), contactName.getMiddleName()));
//            if (contactName.getLastName() != null) {
//                builder.append(contactName.getLastName());
//            }
//            if (contactName.getFirstName() != null) {
//                if (builder.length() > 0) {
//                    builder.append(';');
//                }
//                builder.append(contactName.getFirstName());
//            }
//            if (contactName.getMiddleName() != null) {
//                if (builder.length() > 0) {
//                    builder.append(';');
//                }
//                builder.append(contactName.getMiddleName());
//            }
        }
        if (company != null) {
            builder.append('\n').append("ORG:").append(company);
        }
        if (title != null) {
            builder.append('\n').append("TITLE:").append(title);
        }
        if (phoneNumbers != null && !phoneNumbers.isEmpty()) {
            phoneNumbers.forEach(phoneNumber -> builder.append('\n').append("TEL;TYPE=").append(phoneNumber.getType())
                    .append(":").append(phoneNumber.getNumber()));
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

    @Override
    public ContactName getContactName() {
        return contactName;
    }

    @Override
    public void setContactName(ContactName contactName) {
        this.contactName = contactName;
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
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
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
