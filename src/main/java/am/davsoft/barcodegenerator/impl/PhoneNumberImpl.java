package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.PhoneNumber;
import am.davsoft.barcodegenerator.api.PhoneNumberType;

public class PhoneNumberImpl implements PhoneNumber {
    private PhoneNumberType type = PhoneNumberTypeEnum.CELL;
    private String number;

    @Override
    public PhoneNumberType getType() {
        return type;
    }

    @Override
    public void setType(PhoneNumberType type) {
        this.type = type;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }
}
