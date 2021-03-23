package com.example.contactbook.controllers;

import com.example.contactbook.entities.ContactBookEntity;
import com.example.contactbook.service.ContactBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-book")
public class ContactBookController {

    @Autowired
    private ContactBookService service;

    /**
     * Creates a new contact object when given an contact object and saves it
     * @param contactBookEntity
     * @return return that contact
     */
    @PostMapping(path="/addContact")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactBookEntity addContact(@RequestBody ContactBookEntity contactBookEntity){
        return service.saveContact(contactBookEntity);
    }

    /**
     * Get all contacts
     * @param contactBookEntity
     * @return populated list of contact objects
     */
    @GetMapping(path="/showAllContacts")
    public List<ContactBookEntity> getAllContacts(@RequestBody ContactBookEntity contactBookEntity){
        return service.getContacts();
    }

    /**
     * Fetch a specific contact with given contactID
     * @param id
     * @return a specific contact with given contactID
     */
    @GetMapping(path="/findContactById/{id}")
    public ContactBookEntity findContactById(@PathVariable int id){
        return service.getContactById(id);
    }

    /**
     * Fetch a specific contact with given name
     * @param name
     * @return a specific contact with given name
     */
    @GetMapping(path="/findContactByName/{name}")
    public ContactBookEntity findContactByName(@PathVariable String name){
        return service.getContactByName(name);
    }

    /**
     * Edit a specific contact
     * @param contactBookEntity
     * @return updated contact
     */
    @PutMapping(path="/editContact")
    public ContactBookEntity editContact(@RequestBody ContactBookEntity contactBookEntity){
        return service.updateContact(contactBookEntity);
    }

    /**
     * Removes a specific contact by id
     * @param id
     * @return a String message saying contact has been deleted
     */
    @DeleteMapping(path="/deleteById/{id}")
    public String removeContactById(@PathVariable int id){
        return service.removeContactById(id);
    }

    /**
     * Removes a specific contact by name
     * @param name
     * @return a String message saying contact has been deleted
     */
    @DeleteMapping(path="/deleteByName/{name}")
    public String removeContact(@PathVariable String name){
        return service.removeContact(name);
    }
}
