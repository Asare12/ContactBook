package com.example.contactbook.controllers;

import com.example.contactbook.entities.ContactBookEntity;
import com.example.contactbook.service.ContactBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ContactBookController {

    @Autowired
    private ContactBookService service;

    /**
     * Creates a new contact object when given an contact object and saves it
     * @param contactBookEntity
     * @return created contact page
     */
    @PostMapping(path="/contact-book/addContact")
    public String addContact(@Valid ContactBookEntity contactBookEntity){
        service.saveContact(contactBookEntity);
        return "createContact";
    }

    /**
     * Get all contacts
     * @param model contact data
     * @return view contact page with populated list of contact objects
     */
    @GetMapping(path="/contact-book/showAll")
    public String getAllContacts(Model model){
        model.addAttribute("contacts",service.getContacts());
        return "viewContactList";
    }

    /**
     * Fetch a specific contact with given contactID
     * @param id unique identifier
     * @param model contact data
     * @return the update page
     */
    @GetMapping(path="/contact-book/findContactById/{id}")
    public String findContactById(@PathVariable int id, Model model){
        model.addAttribute("contact", service.getContactById(id));
        return "updateContact";
    }

    @GetMapping(path="/contact-book/{name}")
    public ContactBookEntity findContactByName(@PathVariable String name){
        return service.getContactByName(name);
    }

    /**
     * Searches for contact by name
     * @param searchContact String name passed in for search
     * @param model data
     * @return List of contacts with given name
     */
    @GetMapping("/contact-book")
    public String searchContactForm(@RequestParam(value = "searchContact", required = false, defaultValue = "None") String searchContact, Model model){
        model.addAttribute("contacts", service.getListContactsByName(searchContact));
        return "viewContactList";
    }

    /**
     * Edit a specific contact by id
     * @param contactBookEntity object
     * @param id unique identifier
     * @param model data
     * @return All contacts with updated data
     */
    @GetMapping(path="/contact-book/editContact{id}")
    public String editContact(@Valid ContactBookEntity contactBookEntity, @PathVariable("id") int id, Model model){
        service.updateContact(contactBookEntity, id);
        model.addAttribute("contacts", service.getContacts());
        return getAllContacts(model);
    }

    /**
     * Removes a specific contact by id
     * @param id unique identifier
     * @param model data
     * @return All contacts with updated data
     */
    @GetMapping(path="/contact-book/deleteById/{id}")
    public String removeContactById(@PathVariable int id, Model model) {
        service.removeContactById(id);
        return getAllContacts(model);
    }
}
