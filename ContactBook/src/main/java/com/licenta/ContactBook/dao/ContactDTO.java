package com.licenta.ContactBook.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactDTO {
    private Long id;
    
    private String address;
    
    private String firstName;
    
    private String lastName;
    
    private String phoneNumber;
}
