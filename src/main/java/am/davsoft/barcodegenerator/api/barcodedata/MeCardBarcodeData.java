package am.davsoft.barcodegenerator.api.barcodedata;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public interface MeCardBarcodeData extends BarcodeData {
    String getName();

    void setName(String name);

    String getCompany();

    void setCompany(String company);

    String getPhone();

    void setPhone(String phone);

    String getWebsite();

    void setWebsite(String website);

    String getEmail();

    void setEmail(String email);

    String getAddress();

    void setAddress(String address);

    String getNote();

    void setNote(String note);
}
