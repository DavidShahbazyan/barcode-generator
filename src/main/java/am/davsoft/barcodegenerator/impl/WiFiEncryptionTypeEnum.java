package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.WiFiEncryptionType;

/**
 * @author David.Shahbazyan
 * @since Aug 30, 2018
 */
public enum WiFiEncryptionTypeEnum implements WiFiEncryptionType {
    WPA_WPA2("WPA/WPA2", "WPA"),
    WEP("WEP", "WEP"),
    NONE("NONE", "");

    private final String name;
    private final String value;

    WiFiEncryptionTypeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }
}
