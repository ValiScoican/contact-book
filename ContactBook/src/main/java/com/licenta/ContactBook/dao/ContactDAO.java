package com.licenta.ContactBook.dao;

import lombok.Data;

@Data // NU MERGE !!!! no geter / setter
public class ContactDAO {
    private Long id;
    private String address;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ContactDAO(Long id, String address, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
