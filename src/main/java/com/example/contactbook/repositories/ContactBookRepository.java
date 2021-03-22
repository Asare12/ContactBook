package com.example.contactbook.repositories;

import com.example.contactbook.entities.ContactBookEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ContactBookRepository extends CrudRepository<ContactBookEntity, Integer> {

    /**
     * Find a contact with given name
     * @param name
     * @return the contact with matching name
     */
    ContactBookEntity findByName(String name);

    /**
     * Find all contacts with a specific name
     * @param name
     * @return the list contacts with matching name
     */
    List<ContactBookEntity> findByNameContaining(String name);
}
