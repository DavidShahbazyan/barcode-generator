package am.davsoft.barcodegenerator.builder;

import am.davsoft.barcodegenerator.api.ContactName;
import am.davsoft.barcodegenerator.impl.ContactNameImpl;

public class ContactNameBuilder implements SimpleDataBuilder<ContactName> {
    private String firstName;
    private String middleName;
    private String lastName;

    @Override
    public ContactName buildData() {
        ContactName contactName = new ContactNameImpl();
        contactName.setFirstName(this.firstName);
        contactName.setMiddleName(this.middleName);
        contactName.setLastName(this.lastName);
        return contactName;
    }

    @Override
    public void reset() {
        this.firstName = null;
        this.middleName = null;
        this.lastName = null;
    }

    public ContactNameBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactNameBuilder withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactNameBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
