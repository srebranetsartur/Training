package entities;

import java.time.LocalDate;

public class Visitor {
    private long ID;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String number;

    public Visitor() {}
    

    public Visitor(String firstName, String lastName, LocalDate birthday, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.number = number;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", number='" + number + '\'' +
                '}';
    }
}
