package com.licenta.ContactBook.service;

import com.licenta.ContactBook.dao.ContactDAO;
import com.licenta.ContactBook.exceptions.InvalidDataException;
import com.licenta.ContactBook.model.Contact;
import com.licenta.ContactBook.model.User;
import com.licenta.ContactBook.repository.ContactRepository;
import com.licenta.ContactBook.repository.UserRepository;
import com.licenta.ContactBook.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ContactDAO> getAllContacts(Long Id){
        return contactRepository.findAllByUserId(Id).stream().map((Contact contact) -> {
            return new ContactDAO(
                    contact.getId(),
                    contact.getAddress(),
                    contact.getFirstName(),
                    contact.getLastName(),
                    contact.getPhoneNumber());
        }).collect(Collectors.toList());
    }

    public Contact getContactById(Long Id) throws InvalidDataException {
        UserPrincipal prn = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Contact contact = contactRepository.findContactById(Id);
        if (contact.getUser().getUserId() == prn.getId()) {
            throw new InvalidDataException("AAAAA");
        } else {
            return contact;
        }
    }

    public void deleteContactById(Long Id) throws InvalidDataException {
        UserPrincipal prn = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Contact contact = contactRepository.findContactById(Id);
        if (contact.getUser().getUserId() == prn.getId()) {
            throw new InvalidDataException("AAAAA");
        } else {
            contactRepository.deleteById(Id);
        }
    }

    public void addNewContact(Long userId, ContactDAO newContact) {
        Optional<User> user = userRepository.findById(userId);
        //The purpose of the class (Optional) is to provide a type-level solution
        // for representing optional values instead of null references.

        Contact contact = new Contact(
                newContact.getAddress(),
                newContact.getFirstName(),
                newContact.getLastName(),
                newContact.getPhoneNumber(),
                user.orElse(null));

        contactRepository.save(contact);
    }

    public void updateContact(Long id, ContactDAO contact) throws InvalidDataException {
        UserPrincipal prn = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Contact> current = contactRepository.findById(id);
        Contact cont = current.get();
        if (cont.getUser().getUserId() == prn.getId()) {
            throw new InvalidDataException("AAAAA");
        } else {
            cont.setAddress(contact.getAddress());
            cont.setFirstName(contact.getFirstName());
            cont.setLastName(contact.getLastName());
            cont.setPhoneNumber(contact.getPhoneNumber());
            contactRepository.save(cont);
        }
    }
}
