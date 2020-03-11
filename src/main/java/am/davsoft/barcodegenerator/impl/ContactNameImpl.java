package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.ContactName;

public class ContactNameImpl implements ContactName {
    private String firstName;
    private String middleName;
    private String lastName;

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }

    @Override
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
