package com.licenta.ContactBook.repository;

import com.licenta.ContactBook.model.Contact;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
    // Citeste despre Spring JPA convention.
    List<Contact> findAllByUserId(Long Id, Pageable pageable);

    Contact findContactById(Long Id);
}