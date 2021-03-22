package com.example.contactbook.service;

import com.example.contactbook.entities.ContactBookEntity;
import com.example.contactbook.repositories.ContactBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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

    public List<ContactBookEntity> getListContactsByName(String name){
        return repository.findByNameContaining(name);
    }

    public String removeContactById(int id){
        repository.deleteById(id);
        return "Contact " + id + " has been removed";
    }

    public ContactBookEntity updateContact(ContactBookEntity contact, int id){
        contact.setContactBookId(id);
        return repository.save(contact);
    }
}
