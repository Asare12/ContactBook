package com.example.contactbook.service;

import com.example.contactbook.entities.ContactBookEntity;
import com.example.contactbook.repositories.ContactBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactBookService {

    @Autowired
    private ContactBookRepository repository;

    public ContactBookEntity saveContact(ContactBookEntity contact){
       return repository.save(contact);
    }

    public List<ContactBookEntity> getContacts(){
        return (List<ContactBookEntity>) repository.findAll();
    }

    public ContactBookEntity getContactById(int id){
        return repository.findById(id).orElse(null);
    }

    public ContactBookEntity getContactByName(String name){
        return repository.findByName(name);
    }

    public String removeContactById(int id){
        repository.deleteById(id);
        return "Contact " + id + " has been removed";
    }

    public String removeContact(String name){
        repository.deleteByName(name);
        return "Contact " + name + " has been removed";
    }

    public ContactBookEntity updateContact(ContactBookEntity contact){
        ContactBookEntity existingContact = repository.findById(contact.getContactBookId()).orElse(null);
        existingContact.setName(contact.getName());
        existingContact.setEmail(contact.getEmail());
        existingContact.setPhoneNumber(contact.getPhoneNumber());
        return repository.save(existingContact);
    }

}
