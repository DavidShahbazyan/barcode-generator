package am.davsoft.barcodegenerator.builder;

import am.davsoft.barcodegenerator.api.PhoneNumber;
import am.davsoft.barcodegenerator.api.PhoneNumberType;
import am.davsoft.barcodegenerator.impl.PhoneNumberTypeEnum;
import am.davsoft.barcodegenerator.impl.PhoneNumberImpl;

public class PhoneNumberBuilder implements SimpleDataBuilder<PhoneNumber> {
    private PhoneNumberType type = PhoneNumberTypeEnum.CELL;
    private String number;

    @Override
    public PhoneNumber buildData() {
        PhoneNumber phoneNumber = new PhoneNumberImpl();
        phoneNumber.setType(this.type);
        phoneNumber.setNumber(this.number);
        return phoneNumber;
    }

    @Override
    public void reset() {
        this.type = PhoneNumberTypeEnum.CELL;
        this.number = null;
    }

    public PhoneNumberBuilder withType(PhoneNumberType type) {
        this.type = type;
        return this;
    }

    public PhoneNumberBuilder withNumber(String number) {
        this.number = number;
        return this;
    }
}
