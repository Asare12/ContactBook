package com.example.contactbook.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactBookEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer contactBookId;

    private String name;

    private String email;

    private String phoneNumber;

    public Integer getContactBookId() {
        return contactBookId;
    }

    public void setContactBookId(Integer contactBookId) {
        this.contactBookId = contactBookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
