package am.davsoft.barcodegenerator.api.barcodedata;

import am.davsoft.barcodegenerator.api.WiFiEncryptionType;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public interface WiFiNetworkBarcodeData extends BarcodeData {
    String getSsid();

    void setSsid(String ssid);

    String getPass();

    void setPass(String pass);

    WiFiEncryptionType getEncryptionType();

    void setEncryptionType(WiFiEncryptionType type);

    boolean isHidden();

    void setHidden(boolean hidden);
}
