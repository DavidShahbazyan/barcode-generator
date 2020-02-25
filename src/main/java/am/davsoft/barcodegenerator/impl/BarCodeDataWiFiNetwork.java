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

    public BarCodeDataWiFiNetwork setSsid(String ssid) {
        this.ssid = ssid;
        return this;
    }

    public BarCodeDataWiFiNetwork setPass(String pass) {
        this.pass = pass;
        return this;
    }

    /**
     * @param type The security type [WPA|WEP|NONE]
     * @return
     */
    public BarCodeDataWiFiNetwork setType(WiFiEncryptionType type) {
        this.type = type;
        return this;
    }

    public BarCodeDataWiFiNetwork setHidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    @Override
    public String getData() {
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
