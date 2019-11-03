package com.licenta.ContactBook.controller;

import com.licenta.ContactBook.dao.ContactDAO;
import com.licenta.ContactBook.exceptions.InvalidDataException;
import com.licenta.ContactBook.model.Contact;
import com.licenta.ContactBook.security.UserPrincipal;
import com.licenta.ContactBook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public List<ContactDAO> getAllContacts(){
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return contactService.getAllContacts(principal.getId());
    }

    @GetMapping("/contact")
    public Contact getContactById(@RequestParam("contactId") Long Id) throws InvalidDataException {
        return contactService.getContactById(Id);
    }

    @DeleteMapping("/contact/{Id}")
    public void deleteContactById(@PathVariable Long Id) throws InvalidDataException {
        contactService.deleteContactById(Id);
    }

    @PostMapping("/contact/add")
    public void addContact(@RequestBody ContactDAO newContact) {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal.getId());
        contactService.addNewContact(principal.getId(), newContact);
    }

    @PutMapping("/contact/update/{Id}")
    public void updateContact(@PathVariable Long Id,  @RequestBody ContactDAO contact) throws InvalidDataException {
        contactService.updateContact(Id, contact);
    }

}
