package am.davsoft.barcodegenerator.impl.barcodedata;

import am.davsoft.barcodegenerator.api.WiFiEncryptionType;
import am.davsoft.barcodegenerator.api.barcodedata.BarcodeData;
import am.davsoft.barcodegenerator.api.barcodedata.WiFiNetworkBarcodeData;
import am.davsoft.barcodegenerator.impl.WiFiEncryptionTypeEnum;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class WiFiNetworkBarcodeDataImpl implements WiFiNetworkBarcodeData {
    private String ssid;
    private String pass;
    private WiFiEncryptionType encryptionType;
    private boolean hidden;

    @Override
    public String getDataString() {
        StringBuilder builder = new StringBuilder("WIFI:");
        builder.append("S:").append(ssid);
        if (encryptionType != null && !encryptionType.equals(WiFiEncryptionTypeEnum.NONE)) {
            builder.append(';').append("T:").append(encryptionType.getValue());
        }
        builder.append(';').append("P:").append(pass);
        if (hidden) {
            builder.append(';').append("H:").append("true");
        }
        builder.append(";;");
        return builder.toString();
    }

    @Override
    public String getSsid() {
        return ssid;
    }

    @Override
    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public WiFiEncryptionType getEncryptionType() {
        return encryptionType;
    }

    @Override
    public void setEncryptionType(WiFiEncryptionType encryptionType) {
        this.encryptionType = encryptionType;
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
