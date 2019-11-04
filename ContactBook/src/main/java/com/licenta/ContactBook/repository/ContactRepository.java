package com.licenta.ContactBook.repository;

import com.licenta.ContactBook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Citeste despre Spring JPA convention.
    List<Contact> findAllByUserId(Long Id);

    Contact findContactById(Long Id);
}