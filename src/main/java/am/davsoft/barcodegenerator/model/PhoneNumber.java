package am.davsoft.barcodegenerator.model;

import am.davsoft.barcodegenerator.helper.PhoneNumberType;

public class PhoneNumber {
    private PhoneNumberType type = PhoneNumberType.CELL;
    private String number;

    private PhoneNumber() { }

    public static PhoneNumber newInstance() {
        return new PhoneNumber();
    }

    public PhoneNumber withType(PhoneNumberType type) {
        this.type = type;
        return this;
    }

    public PhoneNumber withNumber(String number) {
        this.number = number;
        return this;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public String toDataString() {
        return number != null ? String.format(";TYPE=%s:%s", type, number) : null;
    }

    @Override
    public String toString() {
        return number != null ? String.format("%s:%s", type, number) : null;
    }
}
