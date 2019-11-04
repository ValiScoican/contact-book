package com.licenta.ContactBook.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String address;
    
    private String firstName;
    
    private String lastName;
    
    private String phoneNumber;
    
    @ManyToOne
    private User user;

    public Contact(String address, String firstName, String lastName, String phoneNumber, User user) {
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }
}