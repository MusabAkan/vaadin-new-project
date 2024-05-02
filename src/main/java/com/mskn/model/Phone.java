package com.mskn.model;

import java.util.Objects;

public class Phone {


    private String fullName;
    private String phoneNumber;

    public Phone(String phoneNumber, String fullName) {

        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(fullName, phone.fullName) && Objects.equals(phoneNumber, phone.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, phoneNumber);
    }
}
