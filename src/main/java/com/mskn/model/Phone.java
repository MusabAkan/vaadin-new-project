package com.mskn.model;

public class Phone {


    private int id;
    private String fullName;
    private String phoneNumber;

    public Phone(int id, String phoneNumber, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
