package am.davsoft.barcodegenerator.model;

public class ContactName {
    private String firstName;
    private String middleName;
    private String lastName;

    private ContactName() { }

    public static ContactName newInstance() {
        return new ContactName();
    }

    public ContactName withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactName withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactName withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (lastName != null) {
            builder.append(lastName);
        }
        if (firstName != null) {
            if (builder.length() > 0) {
                builder.append(';');
            }
            builder.append(firstName);
        }
        if (middleName != null) {
            if (builder.length() > 0) {
                builder.append(';');
            }
            builder.append(middleName);
        }
        return builder.length() > 0 ? builder.toString() : null;
    }
}
