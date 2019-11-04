package com.licenta.ContactBook.service;

import com.licenta.ContactBook.dao.ContactDTO;
import com.licenta.ContactBook.exceptions.InvalidDataException;
import com.licenta.ContactBook.model.Contact;
import com.licenta.ContactBook.model.User;
import com.licenta.ContactBook.repository.ContactRepository;
import com.licenta.ContactBook.repository.UserRepository;
import com.licenta.ContactBook.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public List<ContactDTO> getAllContacts(Long Id, int page, int limit) {
    	Pageable pageRequest = PageRequest.of(page, limit);
        return contactRepository.findAllByUserId(Id, pageRequest).stream().map((Contact contact) -> {
            return new ContactDTO(
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
        if (contact.getUser().getUserId() != prn.getId()) {
            throw new InvalidDataException("Invalid data for current user!");
        } else {
            return contact;
        }
    }

    public void deleteContactById(Long Id) throws InvalidDataException {
        UserPrincipal prn = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Contact contact = contactRepository.findContactById(Id);
        if (contact.getUser().getUserId() != prn.getId()) {
            throw new InvalidDataException("Invalid data for current user!");
        } else {
            contactRepository.deleteById(Id);
        }
    }

    public void addNewContact(Long userId, ContactDTO newContact) {
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

    public void updateContact(Long id, ContactDTO contact) throws InvalidDataException {
        UserPrincipal prn = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Contact> current = contactRepository.findById(id);
        Contact cont = current.get();
        if (cont.getUser().getUserId() != prn.getId()) {
            throw new InvalidDataException("Invalid data for current user!");
        } else {
            cont.setAddress(contact.getAddress());
            cont.setFirstName(contact.getFirstName());
            cont.setLastName(contact.getLastName());
            cont.setPhoneNumber(contact.getPhoneNumber());
            contactRepository.save(cont);
        }
    }
}
