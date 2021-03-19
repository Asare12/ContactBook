package com.example.contactbook.controllers;

import com.example.contactbook.entities.ContactBookEntity;
import com.example.contactbook.repositories.ContactBookRepository;
import com.example.contactbook.service.ContactBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactBookController {

    @Autowired
    private ContactBookService service;

    @PostMapping(path="/contact-book/add")
    public ContactBookEntity addContact(@RequestBody ContactBookEntity contactBookEntity){
        return service.saveContact(contactBookEntity);
    }

    @GetMapping(path="/contact-book/showAll")
    public List<ContactBookEntity> getAllContacts(@RequestBody ContactBookEntity contactBookEntity){
        return service.getContacts();
    }

    @GetMapping(path="/contact-book/findContactById/{id}")
    public ContactBookEntity findContactById(@PathVariable int id){
        return service.getContactById(id);
    }

    @GetMapping(path="/contact-book/{name}")
    public ContactBookEntity findContactByName(@PathVariable String name){
        return service.getContactByName(name);
    }

    @PutMapping(path="/contact-book/editContact")
    public ContactBookEntity editContact(@RequestBody ContactBookEntity contactBookEntity){
        return service.updateContact(contactBookEntity);
    }

    @DeleteMapping(path="/contact-book/deleteById/{id}")
    public String removeContactById(@PathVariable int id){
        return service.removeContactById(id);
    }
    @DeleteMapping(path="/contact-book/delete/{name}")
    public String removeContact(@PathVariable String name){
        return service.removeContact(name);
    }
}
