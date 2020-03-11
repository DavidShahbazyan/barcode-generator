package am.davsoft.barcodegenerator.api.barcodedata;

import am.davsoft.barcodegenerator.api.ContactName;
import am.davsoft.barcodegenerator.api.PhoneNumber;

import java.util.List;

/**
 * <b>VCard in Wiki:</b> https://ru.wikipedia.org/wiki/VCard
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public interface VCardBarcodeData extends BarcodeData {
    ContactName getContactName();

    void setContactName(ContactName contactName);

    String getCompany();

    void setCompany(String company);

    String getTitle();

    void setTitle(String title);

    List<PhoneNumber> getPhoneNumbers();

    void setPhoneNumbers(List<PhoneNumber> phoneNumbers);

    String getWebsite();

    void setWebsite(String website);

    String getEmail();

    void setEmail(String email);

    String getAddress();

    void setAddress(String address);

    String getNote();

    void setNote(String note);
}
