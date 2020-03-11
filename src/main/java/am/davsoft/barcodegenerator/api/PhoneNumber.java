package am.davsoft.barcodegenerator.api;

public interface PhoneNumber {
    PhoneNumberType getType();

    void setType(PhoneNumberType type);

    String getNumber();

    void setNumber(String number);
}
