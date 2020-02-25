package am.davsoft.barcodegenerator.helper;

/**
 * @author David.Shahbazyan
 * @since Aug 30, 2018
 */
public enum WiFiEncryptionType {
    WPA_WPA2("WPA/WPA2", "WPA"),
    WEP("WEP", "WEP"),
    NONE("NONE", "");

    private final String name;
    private final String value;

    WiFiEncryptionType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
