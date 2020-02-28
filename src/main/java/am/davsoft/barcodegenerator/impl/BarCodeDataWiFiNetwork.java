package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;
import am.davsoft.barcodegenerator.helper.WiFiEncryptionType;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataWiFiNetwork implements BarCodeData {
    private String ssid;
    private String pass;
    private WiFiEncryptionType type;
    private boolean hidden;

    private BarCodeDataWiFiNetwork() { }

    public static BarCodeDataWiFiNetwork newInstance() {
        return new BarCodeDataWiFiNetwork();
    }

    public BarCodeDataWiFiNetwork withSsid(String ssid) {
        this.ssid = ssid;
        return this;
    }

    public BarCodeDataWiFiNetwork withPass(String pass) {
        this.pass = pass;
        return this;
    }

    /**
     * @param type The security type [WPA|WEP|NONE]
     * @return
     */
    public BarCodeDataWiFiNetwork withType(WiFiEncryptionType type) {
        this.type = type;
        return this;
    }

    public BarCodeDataWiFiNetwork withHidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    public String getSsid() {
        return ssid;
    }

    public String getPass() {
        return pass;
    }

    public WiFiEncryptionType getType() {
        return type;
    }

    public boolean isHidden() {
        return hidden;
    }

    @Override
    public String getDataString() {
        StringBuilder builder = new StringBuilder("WIFI:");
        builder.append("S:").append(ssid);
        if (type != null && !type.equals(WiFiEncryptionType.NONE)) {
            builder.append(';').append("T:").append(type.getValue());
        }
        builder.append(';').append("P:").append(pass);
        if (hidden) {
            builder.append(';').append("H:").append("true");
        }
        builder.append(";;");
        return builder.toString();
    }
}
