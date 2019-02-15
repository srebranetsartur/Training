package org.training.model.entities;

import org.training.model.validator.Validator;

import java.time.LocalDateTime;
/**
 * Represent a single user record
 */
public class UserRecord {
    private String name;
    private String lastName;
    private String middleName;
    private String initial;
    private String nickname;
    private String comment;
    private Group group;
    private String mobileNumber;
    private String second_mobile;
    private String email;
    private String skype;
    private Address address;
    private String fullAddress;
    private LocalDateTime registerTimestamp;
    private LocalDateTime lastEditTimestamp;

    enum Group {
        CONTACT,FAMILY,FRIENDS,CLASSMATES,NEIGHBOR,COWORKERS
    }

    class Address {
        private String city;
        private String street;
        private String houseNumber;
        private int flatNumber;

        public Address(String city, String street, String houseNumber, int flatNumber) {
            this.city = city;
            this.street = street;
            this.houseNumber = houseNumber;
            this.flatNumber = flatNumber;
        }
    }

    public static class Builder {
        private Validator validator;
        //Required parameters
        private String name;
        private String lastName;
        private String nickname;
        private String mobileNumber;

        private String middleName;
        private String comment = "";
        private String secondMobileNumber = "-";
        private String email = "-";
        private String skype = "-";
        private Group group = Group.CONTACT;
        private Address address;

        public Builder(String name, String lastName, String nickname, String mobileNumber) {
            this.name = name;
            this.lastName = lastName;
            this.nickname = nickname;
            this.mobileNumber = mobileNumber;
        }

        public void middleName(String middleName) {
            this.middleName = middleName; }

        public void comment(String comment) { this.comment = comment; }

        public void secondMobileNumber(String secondMobileNumber) { this.secondMobileNumber = secondMobileNumber; }

        public void email(String email) {this.email = email;}

        public void skype(String skype) {this.skype = skype;}

        public void group(Group group) {this.group = group;}

        public void address(Address address) {this.address = address;}
    }

    private UserRecord(Builder builder) {
        name = builder.name;
        lastName = builder.lastName;
        middleName = builder.middleName;

        initial = lastName + name +
                name.substring(0, 1) +
                ".";

        nickname = builder.nickname;
        comment = builder.comment;
        group = builder.group;
        mobileNumber = builder.mobileNumber;
        second_mobile = builder.secondMobileNumber;
        email = builder.email;
        skype = builder.skype;
        address = builder.address;
        fullAddress = address.city + ","
                + address.street
                + address.houseNumber + "/" + address.flatNumber;
        registerTimestamp = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getInitial() {
        return initial;
    }

    public String getNickname() {
        return nickname;
    }

    public String getComment() {
        return comment;
    }

    public Group getGroup() {
        return group;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getSecond_mobile() {
        return second_mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getSkype() {
        return skype;
    }


    public Address getAddress() {
        return address;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public LocalDateTime getRegisterTimestamp() {
        return registerTimestamp;
    }

    public LocalDateTime getLastEditTimestamp() {
        return lastEditTimestamp;
    }
}

