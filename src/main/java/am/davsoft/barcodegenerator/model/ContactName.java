package am.davsoft.barcodegenerator.model;

public class ContactName {
    private String firstName;
    private String middleName;
    private String lastName;

    public ContactName setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactName setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactName setLastName(String lastName) {
        this.lastName = lastName;
        return this;
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
