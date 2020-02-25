package am.davsoft.barcodegenerator.model;

import am.davsoft.barcodegenerator.helper.PhoneNumberType;

public class PhoneNumber {
    private PhoneNumberType type = PhoneNumberType.CELL;
    private String number;

    public PhoneNumber setType(PhoneNumberType type) {
        this.type = type;
        return this;
    }

    public PhoneNumber setNumber(String number) {
        this.number = number;
        return this;
    }

    public String toDataString() {
        return number != null ? String.format(";TYPE=%s:%s", type, number) : null;
    }

    @Override
    public String toString() {
        return number != null ? String.format("%s:%s", type, number) : null;
    }
}
