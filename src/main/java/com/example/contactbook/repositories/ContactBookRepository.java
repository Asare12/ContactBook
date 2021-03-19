package com.example.contactbook.repositories;

import com.example.contactbook.entities.ContactBookEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContactBookRepository extends CrudRepository<ContactBookEntity, Integer> {

    ContactBookEntity findByName(String name);

    void deleteByName(String name);
}
