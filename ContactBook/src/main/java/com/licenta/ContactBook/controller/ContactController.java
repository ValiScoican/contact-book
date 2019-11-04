package com.licenta.ContactBook.controller;

import com.licenta.ContactBook.dao.ContactDTO;
import com.licenta.ContactBook.exceptions.InvalidDataException;
import com.licenta.ContactBook.model.Contact;
import com.licenta.ContactBook.security.UserPrincipal;
import com.licenta.ContactBook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *	Rest controller for contacts model.
 */
@RestController
public class ContactController {

	/**
	 * Contacts service. Get data from repositories.
	 */
    @Autowired
    private ContactService contactService;

    /**
     * Return all contacts for current logged user.
     * 
     * @param page - current page.
     * @param limit - data limit.
     * @return List of contacts.
     */
    @GetMapping("/contacts")
    public List<ContactDTO> getAllContacts(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return contactService.getAllContacts(principal.getId(), page, limit);
    }

    /**
     * Return given contact by ID.
     * 
     * @param Id - contact ID.
     * @return contact data.
     * @throws InvalidDataException thrown when other users try to access invalid contacts.
     */
    @GetMapping("/contact")
    public Contact getContactById(@RequestParam("contactId") Long Id) throws InvalidDataException {
        return contactService.getContactById(Id);
    }

    /**
     * Delete contact by ID.
     * 
     * @param Id - given contact.
     * @throws InvalidDataException thrown when other users try to access invalid contacts.
     */
    @DeleteMapping("/contact/{Id}")
    public void deleteContactById(@PathVariable Long Id) throws InvalidDataException {
        contactService.deleteContactById(Id);
    }

    /**
     * Add new contact.
     * 
     * @param newContact contact DTO.
     */
    @PostMapping("/contact/add")
    public void addContact(@RequestBody ContactDTO newContact) {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        contactService.addNewContact(principal.getId(), newContact);
    }

    @PutMapping("/contact/update/{Id}")
    public void updateContact(@PathVariable Long Id,  @RequestBody ContactDTO contact) throws InvalidDataException {
        contactService.updateContact(Id, contact);
    }

}
