package org.training.model.entities;

/**
 * Represent a single user record
 */
public final class UserRecord {
    private String name;
    private String lastName;
    private final String login;
    private String number;

    public UserRecord(String name, String lastName, String login, String number) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof UserRecord)) return false;
        UserRecord ur = (UserRecord) obj;
        return name.equals(ur.name) && lastName.equals(ur.lastName)
                && login.equals(ur.login) && number.equals(ur.number);
    }

    @Override
    public int hashCode() {
        int hash = name.hashCode();
        hash = 31 * hash + lastName.hashCode();
        hash = 31*hash + login.hashCode();
        hash = 31*hash + number.hashCode();

        return hash;
    }

    @Override
    public String toString() {
        String COMA_DELIMITER = ", ";

        StringBuilder sb = new StringBuilder("Record: {");
        sb.append(name).append(COMA_DELIMITER)
                .append(lastName).append(COMA_DELIMITER)
                .append(login).append(COMA_DELIMITER)
                .append(number).append("}");

        return sb.toString();
    }


    public String getLogin() {
        return login;
    }
}

